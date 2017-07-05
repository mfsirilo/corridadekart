package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Metodos implements Serializable {

    static String enderecoCompetidor = "/home/marcos/Documentos/pratica3/Trabalhos/Competidor.bin";
    static String enderecoClassifica = "/home/marcos/Documentos/pratica3/Trabalhos/Classifica.bin";
    int codCom = 0;

    Scanner scan = new Scanner(System.in);

    public static void limparTela() {
        System.out.println("");
        for (int i = 0; i != 50; ++i) {
            System.out.println("");
        }
        System.out.println("");
    }

    public void Menuprincipal() {

        System.out.println("=======================================");
        System.out.println("Menu principal ");
        System.out.println("=======================================");
        System.out.println("Informe uma opçcão de acordo com o Menu:");
        System.out.println("Digite 1 para Competidores");
        System.out.println("Digite 2 para Corridas");
        System.out.println("Digite 3 para Relatórios");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");

    }

    public void MenuCompetidor() {
        System.out.println("=======================================");
        System.out.println("Menu Competidores ");
        System.out.println("=======================================");
        System.out.println("Digite 1 para cadastrar novo Competidor");
        System.out.println("Digite 2 para excluir Competidor");
        System.out.println("Digite 3 para imprimir TODOS os Competidores");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }

    public void CadastroCompetidor(ArrayList<Competidor> listaCompetidores, String nome, float ponto, int numClassifica) {
        listaCompetidores = ControleKart.leituramentacaoArquivo(listaCompetidores, enderecoCompetidor);
        Competidor competidor = new Competidor(codCom, nome, ponto, numClassifica);
        if (listaCompetidores.size() > 0) {
            int ultimocliente = listaCompetidores.get(listaCompetidores.size() - 1).getCodCom();
            competidor.setCodCom(ultimocliente + 1);//parte do codigo que seta 
            listaCompetidores.add(competidor);
            ControleKart.gravamentacaoArquivo(listaCompetidores, enderecoCompetidor);
        } else {
            listaCompetidores.add(competidor);
            ControleKart.gravamentacaoArquivo(listaCompetidores, enderecoCompetidor);
        }
    }

    public static int UltimoCodigo(ArrayList<Competidor> listacompetidor) {
        listacompetidor = ControleKart.leituramentacaoArquivo(listacompetidor, enderecoCompetidor);
        int ultimocodigo = listacompetidor.get(listacompetidor.size() - 1).getCodCom();
        return ultimocodigo;
    }

    public void ExcluirCorredor(ArrayList<Competidor> listacompetidor, int codigo) {
        listacompetidor = ControleKart.leituramentacaoArquivo(listacompetidor, enderecoCompetidor);

        System.out.println("=======================================");
        System.out.println("Exclusão de competidor cadastrado");
        System.out.println("=======================================");

        System.out.println("Informe o codigo do competidor");
        codigo = scan.nextInt();
        listacompetidor.remove(RetornaIndiceCorredor(codigo, listacompetidor));
        listacompetidor = ControleKart.gravamentacaoArquivo(listacompetidor, enderecoCompetidor);
    }

    public static int RetornaIndiceCorredor(int codigo, ArrayList<Competidor> listacompetidor) {
        int index = 0;
        for (int i = 0; i < listacompetidor.size(); i++) {
            if (listacompetidor.get(i).getCodCom() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public void ImprimeCorredor(ArrayList<Competidor> listacompetidor, int codigo) {
        listacompetidor = ControleKart.leituramentacaoArquivo(listacompetidor, enderecoCompetidor);
        if (codigo == 99) {
            System.out.println("=======================================");
            System.out.println("Lista de todos os clientes");
            System.out.println("=======================================");
            for (Competidor corredor : listacompetidor) {
                System.out.println("Codigo: " + corredor.getCodCom());
                System.out.println("Nome: " + corredor.getNome());
                System.out.println("Pontos: " + corredor.getPonto());
                System.out.println("");
                System.out.println("--------------------"
                        + "");
            }
        } else {
            int indice = RetornaIndiceCorredor(codigo, listacompetidor);
            System.out.println("=======================================");
            System.out.println("Cadastro do cliente: ");
            System.out.println("=======================================");

            System.out.println("=======================================");
            System.out.println("Indice: " + indice);
            System.out.println("Codigo: " + listacompetidor.get(indice).getCodCom());
            System.out.println("Nome: " + listacompetidor.get(indice).getNome());
            System.out.println("Pontos: " + listacompetidor.get(indice).getPonto());
        }
    }

    public void MenuCorrida() {
        System.out.println("=======================================");
        System.out.println("Menu Corrida ");
        System.out.println("=======================================");
        System.out.println("Digite 1 para cadastro de corrida ");
        System.out.println("Digite 2 para imprimir corridas ");
        System.out.println("Digite 3 para excluir corridas: ");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }

    public void CadastroCorrida(ArrayList<Classifica> listaclassifica, int CodCorrida, int CodCompetidor, String localCorrida, float pontosCompetidor) {
        Classifica clas = new Classifica(CodCorrida, CodCompetidor, localCorrida, pontosCompetidor);
        listaclassifica.add(clas);
        ControleKart.gravamentacaoArquivo(listaclassifica, enderecoClassifica);
    }

    public void ImprimeCorrida(ArrayList<Classifica> listaclassifica, ArrayList<Competidor> listacompetidor) {
        listaclassifica = ControleKart.leituramentacaoArquivo(listaclassifica, enderecoClassifica);
        listaclassifica = ControleKart.leituramentacaoArquivo(listacompetidor, enderecoCompetidor);
        System.out.println("=======================================");
        System.out.println("Lista de voos cadastrados");
        System.out.println("=======================================");
        for (Classifica clas : listaclassifica) {
            System.out.println("");
            System.out.println("Corrida n°: " + clas.getCodCorrida());
            System.out.println("Local: " + clas.getLocalCorrida());
            for (Competidor comp : listacompetidor) {
                System.out.println("Competidor: " + comp.getNome());
                System.out.println("Classificou-se em: " + comp.getNumClassificacao());
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("FIM DA LISTA DE VOOS");
        System.out.println("");

    }

//    public void excluirVoo(ArrayList<Voos> listavoo, int codigo) {
//        listavoo.remove(RetornaIndiceCorridas(codigo, listavoo));
//        ControledeMilhagem.gravamentoArquivo(listavoo, enderecoVoo);
//    }
//    public void cadastroVoocliente(Clientes cliente, Voos voo, int data, int hora) {
//        int codc, codv;
//        codc = cliente.getCodCli();
//        codv = voo.getCodigoVoo();
//
//        Voocliente vooC = new Voocliente(codc, codv, data, hora);
//        //funfa
//        String enderecoArquivo;
//        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
//        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
//        listaVooClientes.add(vooC);
//        listaVooClientes = ControledeMilhagem.gravamentoArquivo(listaVooClientes, enderecoArquivo);
//
//    }
//    public void excluirVoocliente(Clientes cliente) {
//        String enderecoArquivo;
//        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
//        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
//        for (Voocliente vcli : listaVooClientes) {
//            System.out.println("Codigo do Voo: " + vcli.getCodVoo());
//        }
//        System.out.println("Informe o codigo do voo a ser excluido: ");
//        int codvoo = scan.nextInt();
//        scan.nextLine();
//        listaVooClientes.remove(retornaIndiceVoosClientes(codvoo, listaVooClientes));
//        listaVooClientes = ControledeMilhagem.gravamentoArquivo(listaVooClientes, enderecoArquivo);
//
//    }
//
//    public static int retornaIndiceVoosClientes(int codVoo, ArrayList<Voocliente> listaVooClientes) {
//        int index = 0;
//        for (int i = 0; i < listaVooClientes.size(); i++) {
//            if (listaVooClientes.get(i).getCodVoo() == codVoo) {
//                index = i;
//            }
//        }
//        return index;
//    }
    public static int RetornaIndiceCorridas(int codigo, ArrayList<Classifica> listaclassifica) {
        int index = 0;
        for (int i = 0; i < listaclassifica.size(); i++) {
            if (listaclassifica.get(i).getCodCorrida() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public void menuRelatorio() {
        System.out.println("=======================================");
        System.out.println("Menu relatório: ");
        System.out.println("=======================================");

        System.out.println("Digite 1 para exibição de histórico de voo por cliente");
        System.out.println("Digite 2 para exibição de saldo de milhas individuais");
        System.out.println("Digite 3 para exibição de saldo de milhas familiar");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");
    }

//    public void historicoVooCliente(ArrayList<Clientes> listaclientes, int codigo) {
//        Clientes cliente = new Clientes();
//        cliente = RetornaCompetidor(listaclientes, codigo);
//        String enderecoArquivo;
//        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
//        listaVooClientes.clear();
//        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
//
//        System.out.println("=======================================");
//        System.out.println("Histórico de Voos por cliente");
//        System.out.println("=======================================");
//
//        for (Voocliente vcli : listaVooClientes) {
//
//            System.out.println("Codigo Voo: " + vcli.getCodVoo());
//            System.out.println("Codigo Data: " + vcli.getData());
//            System.out.println("Codigo Hora: " + vcli.getHora());
//            System.out.println("---------------------------------");
//        }
//        System.out.println("");
//        System.out.println("FIM DA LISTA");
//        System.out.println("");
//
//    }
    public Competidor RetornaCompetidor(ArrayList<Competidor> listacompetidor, int codigo) {
        listacompetidor = ControleKart.leituramentacaoArquivo(listacompetidor, enderecoCompetidor);
        int indice = RetornaIndiceCorredor(codigo, listacompetidor);
        Competidor competidor = new Competidor();
        competidor = listacompetidor.get(indice);
        return competidor;
    }

//    public void saldoMilhasIndividual(ArrayList<Clientes> listaclientes, int codigo, ArrayList<Voos> listaVoos) {
//        Clientes cliente = new Clientes();
//        cliente = RetornaCompetidor(listaclientes, codigo);
//        double distancia = 0;
//        String enderecoArquivo;
//        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
//        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
//        for (Voocliente vcli : listaVooClientes) {
//            int codVoo = vcli.getCodVoo();
//            distancia += listaVoos.get(RetornaIndiceCorridas(codVoo, listaVoos)).getDistancia();
//        }
//        int categoria = cliente.getCategoria();
//        if (categoria == 0) {
//            distancia = distancia * 0.621;
//        }
//        if (categoria == 1) {
//            distancia = ((distancia * 0.621) * 1.5);
//        }
//        if (categoria == 2) {
//            distancia = ((distancia * 0.621) * 2);
//        }
//        System.out.println("=======================================");
//        System.out.println("Saldo de Milhas individual é:");
//        System.out.println("=======================================");
//        System.out.println("");
//        System.out.println("O cliente " + cliente.getNome() + "\n");
//        System.out.println("A milhagem acumulada é de: " + Math.ceil(distancia) + "\n");
//        System.out.println("");
//        System.out.println("=======================================");
//    }
//    public void saldoMilhasFamiliar(ArrayList<Clientes> listaclientes, int codigo, ArrayList<Voos> listaVoos) {
//        double distancia = 0, distanciaC = 0;
//        Clientes cliente = new Clientes();
//        Clientes conjuge = new Clientes();
//        cliente = RetornaCompetidor(listaclientes, codigo);
//        if (cliente.getCodConjuge() == -1) {
//            saldoMilhasIndividual(listaclientes, codigo, listaVoos);
//        } else {
//            conjuge = RetornaCompetidor(listaclientes, cliente.getCodConjuge());
//            String enderecoArquivo;
//            enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
//            listaVooClientes.clear();
//            listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
//            for (Voocliente vcli : listaVooClientes) {
//                int codVoo = vcli.getCodVoo();
//                distancia += listaVoos.get(RetornaIndiceCorridas(codVoo, listaVoos)).getDistancia();
//                int categoria = cliente.getCategoria();
//                if (categoria == 0) {
//                    distancia = distancia * 0.621;
//                }
//                if (categoria == 1) {
//                    distancia = (distancia * 0.621) * 1.5;
//                }
//                if (categoria == 2) {
//                    distancia = (distancia * 0.621) * 2;
//                }
//            }
//            String enderecoArquivoC = "D:\\Facul\\ControleMilhagem\\" + conjuge.getNome() + conjuge.getCodCli() + ".bin";
//            listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivoC);
//            for (Voocliente vCon : listaVooClientes) {
//                int codVooC = vCon.getCodVoo();
//                distanciaC += listaVoos.get(RetornaIndiceCorridas(codVooC, listaVoos)).getDistancia();
//                int categoriaC = conjuge.getCategoria();
//                if (categoriaC == 0) {
//                    distanciaC = distanciaC * 0.621;
//                }
//                if (categoriaC == 1) {
//                    distanciaC = (distanciaC * 0.621) * 1.5;
//                }
//                if (categoriaC == 2) {
//                    distanciaC = (distanciaC * 0.621) * 2;
//                }
//            }
//            //System.out.println("Distancia Cliente -> " + Math.ceil(distancia));
//            //System.out.println("Distancia conjuge -> " + Math.ceil(distanciaC));
//            System.out.println("=======================================");
//            System.out.println("Saldo de Milhas familiar");
//            System.out.println("=======================================");
//
//            System.out.println("A soma da milhagem familiar é: " + Math.ceil(distancia + distanciaC));
//            System.out.println("");
//        }
//
//    }
}
