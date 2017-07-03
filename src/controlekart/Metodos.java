package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Metodos {

    String enderecoCorredor = "/home/marcos/Documentos/pratica3/Trabalhos/Corredor.bin";
    String enderecoClassifica = "/home/marcos/Documentos/pratica3/Trabalhos/Classifica.bin";

    Scanner scan = new Scanner(System.in);

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

    public void MenuCorredor() {
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

    public void cadastroCompetidor(ArrayList<Competidores> listaCompetidores,int codCom, String nome, float ponto) {
        Metodos cadastrocliente = new Metodos();
        //Carrega os clientes do arquivo pra lista
        listaCompetidores = ControleKart.leituramentacaoArquivo(listaCompetidores, enderecoCorredor);

        Competidores competidor = new Competidores(codCom, nome, ponto);
        if (listaCompetidores.size() > 0) {
            int ultimocliente = listaCompetidores.get(listaCompetidores.size() - 1).getCodCom();
            competidor.setCodCom(ultimocliente + 1);//parte do codigo que seta 
            listaCompetidores.add(competidor);
            ControleKart.gravamentacaoArquivo(listaCompetidores, enderecoCorredor);
        } else {
            listaCompetidores.add(competidor);
            ControleKart.gravamentacaoArquivo(listaCompetidores, enderecoCorredor);

        }
    }

    public static int ultimoCodigo(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        int ultimocodigo = listaclientes.get(listaclientes.size() - 1).getCodCli();
        return ultimocodigo;
    }

    public void excluirCliente(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);

        //Aqui busca o cliente pelo código e usa o método remove para tirar o cliente da lista
        System.out.println("=======================================");
        System.out.println("Exclusão de cliente");
        System.out.println("=======================================");

        System.out.println("Informe o codigo do cliente");
        int codigo = scan.nextInt();
        listaclientes.remove(retornaIndiceCliente(codigo, listaclientes));
        listaclientes = ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);

    }

    //Metodo que procurar o indide do cliente dentro do arraylist atrav�s do c�digo
    public static int retornaIndiceCliente(int codigo, ArrayList<Clientes> listaclientes) {
        int index = 0;
        for (int i = 0; i < listaclientes.size(); i++) {
            if (listaclientes.get(i).getCodCli() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public void imprimeCliente(ArrayList<Clientes> listaclientes, int codigo) {
        String NomeConjuge;
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        int codC;
        if (codigo == 0) {
            System.out.println("=======================================");
            System.out.println("Lista de todos os clientes");
            System.out.println("=======================================");
            for (Clientes cli : listaclientes) {
                System.out.println("Codigo: " + cli.getCodCli());
                System.out.println("Nome: " + cli.getNome());
                System.out.println("Sexo: " + cli.getSexo());
                System.out.println("CPF: " + cli.getCpf());
                System.out.println("Categoria: " + cli.getCategoria());
                System.out.println("Codigo do Conjuge: " + cli.getCodConjuge());
                if (cli.getCodConjuge() == -1) {
                    NomeConjuge = "Não informado";
                } else {
                    NomeConjuge = listaclientes.get(retornaIndiceCliente(cli.getCodConjuge(),
                            listaclientes)).getNome();
                }
                System.out.println("Nome Conjuge: " + NomeConjuge);
                System.out.println("----------------------------------");
            }
        } else {
            int indice = retornaIndiceCliente(codigo, listaclientes);
            System.out.println("=======================================");
            System.out.println("Cadastro do cliente: ");
            System.out.println("=======================================");

            System.out.println("=======================================");
            System.out.println("Indice: " + indice);
            System.out.println("Codigo: " + listaclientes.get(indice).getCodCli());
            System.out.println("Nome: " + listaclientes.get(indice).getNome());
            System.out.println("Sexo: " + listaclientes.get(indice).getSexo());
            System.out.println("CPF: " + listaclientes.get(indice).getCpf());
            System.out.println("Categoria: " + listaclientes.get(indice).getCategoria());
            codC = listaclientes.get(indice).getCodConjuge();
            System.out.println("Codigo do Conjuge: " + codC);
            if (codC == -1) {
                NomeConjuge = "Não informado";
            } else {
                NomeConjuge = listaclientes.get(retornaIndiceCliente(codC,
                        listaclientes)).getNome();
            }
            System.out.println("Nome Conjuge: " + NomeConjuge);
            System.out.println("=======================================");
        }
    }

    public void menuVoo() {
        System.out.println("=======================================");
        System.out.println("Menu voo ");
        System.out.println("=======================================");
        System.out.println("Digite 1 para cadastro de Voo: ");
        System.out.println("Digite 2 para imprimir todos Voos cadastrados: ");
        System.out.println("Digite 3 para excluir de Voo: ");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }

    public void cadastroVoo(ArrayList<Voos> listaVoos, int codV, String origem, String destino, float dist) {
        /*O codigo de voos não é incremental, o codigo de voo é definido de acordo com a compania
        *Escala cidades e etc. Então o usuário q vai digitar.
         */
        Voos voo = new Voos(codV, origem, destino, dist);
        listaVoos.add(voo);
        ControledeMilhagem.gravamentoArquivo(listaVoos, enderecoVoo);
    }

    public void imprimeVoo(ArrayList<Voos> listaVoos) {
        listaVoos = ControledeMilhagem.leituramentoArquivo(listaVoos, enderecoVoo);
        System.out.println("=======================================");
        System.out.println("Lista de voos cadastrados");
        System.out.println("=======================================");
        for (Voos voo : listaVoos) {
            System.out.println("Codigo: " + voo.getCodigoVoo());
            System.out.println("Origem: " + voo.getOrigem());
            System.out.println("Destino: " + voo.getDestino());
            System.out.println("Distância: " + voo.getDistancia());
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("FIM DA LISTA DE VOOS");
        System.out.println("");

    }

    public void excluirVoo(ArrayList<Voos> listavoo, int codigo) {
        listavoo.remove(retornaIndiceVoos(codigo, listavoo));
        ControledeMilhagem.gravamentoArquivo(listavoo, enderecoVoo);
    }

    public void cadastroVoocliente(Clientes cliente, Voos voo, int data, int hora) {
        int codc, codv;
        codc = cliente.getCodCli();
        codv = voo.getCodigoVoo();

        Voocliente vooC = new Voocliente(codc, codv, data, hora);
        //funfa
        String enderecoArquivo;
        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
        listaVooClientes.add(vooC);
        listaVooClientes = ControledeMilhagem.gravamentoArquivo(listaVooClientes, enderecoArquivo);

    }

    public void excluirVoocliente(Clientes cliente) {
        String enderecoArquivo;
        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
        for (Voocliente vcli : listaVooClientes) {
            System.out.println("Codigo do Voo: " + vcli.getCodVoo());
        }
        System.out.println("Informe o codigo do voo a ser excluido: ");
        int codvoo = scan.nextInt();
        scan.nextLine();
        listaVooClientes.remove(retornaIndiceVoosClientes(codvoo, listaVooClientes));
        listaVooClientes = ControledeMilhagem.gravamentoArquivo(listaVooClientes, enderecoArquivo);

    }

    public static int retornaIndiceVoosClientes(int codVoo, ArrayList<Voocliente> listaVooClientes) {
        int index = 0;
        for (int i = 0; i < listaVooClientes.size(); i++) {
            if (listaVooClientes.get(i).getCodVoo() == codVoo) {
                index = i;
            }
        }
        return index;
    }

    public static int retornaIndiceVoos(int codigo, ArrayList<Voos> listaVoos) {
        int index = 0;
        for (int i = 0; i < listaVoos.size(); i++) {
            if (listaVoos.get(i).getCodigoVoo() == codigo) {
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

    public void historicoVooCliente(ArrayList<Clientes> listaclientes, int codigo) {
        Clientes cliente = new Clientes();
        cliente = retornaCliente(listaclientes, codigo);
        String enderecoArquivo;
        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
        listaVooClientes.clear();
        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);

        System.out.println("=======================================");
        System.out.println("Histórico de Voos por cliente");
        System.out.println("=======================================");

        for (Voocliente vcli : listaVooClientes) {

            System.out.println("Codigo Voo: " + vcli.getCodVoo());
            System.out.println("Codigo Data: " + vcli.getData());
            System.out.println("Codigo Hora: " + vcli.getHora());
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("FIM DA LISTA");
        System.out.println("");

    }

    public Clientes retornaCliente(ArrayList<Clientes> listaclientes, int codigo) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        int indice = retornaIndiceCliente(codigo, listaclientes);
        Clientes cliente = new Clientes();
        cliente = listaclientes.get(indice);
        return cliente;
    }

    public void saldoMilhasIndividual(ArrayList<Clientes> listaclientes, int codigo, ArrayList<Voos> listaVoos) {
        Clientes cliente = new Clientes();
        cliente = retornaCliente(listaclientes, codigo);
        double distancia = 0;
        String enderecoArquivo;
        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
        listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
        for (Voocliente vcli : listaVooClientes) {
            int codVoo = vcli.getCodVoo();
            distancia += listaVoos.get(retornaIndiceVoos(codVoo, listaVoos)).getDistancia();
        }
        int categoria = cliente.getCategoria();
        if (categoria == 0) {
            distancia = distancia * 0.621;
        }
        if (categoria == 1) {
            distancia = ((distancia * 0.621) * 1.5);
        }
        if (categoria == 2) {
            distancia = ((distancia * 0.621) * 2);
        }
        System.out.println("=======================================");
        System.out.println("Saldo de Milhas individual é:");
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("O cliente " + cliente.getNome() + "\n");
        System.out.println("A milhagem acumulada é de: " + Math.ceil(distancia) + "\n");
        System.out.println("");
        System.out.println("=======================================");
    }

    public void saldoMilhasFamiliar(ArrayList<Clientes> listaclientes, int codigo, ArrayList<Voos> listaVoos) {
        double distancia = 0, distanciaC = 0;
        Clientes cliente = new Clientes();
        Clientes conjuge = new Clientes();
        cliente = retornaCliente(listaclientes, codigo);
        if (cliente.getCodConjuge() == -1) {
            saldoMilhasIndividual(listaclientes, codigo, listaVoos);
        } else {
            conjuge = retornaCliente(listaclientes, cliente.getCodConjuge());
            String enderecoArquivo;
            enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + cliente.getNome() + cliente.getCodCli() + ".bin";
            listaVooClientes.clear();
            listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivo);
            for (Voocliente vcli : listaVooClientes) {
                int codVoo = vcli.getCodVoo();
                distancia += listaVoos.get(retornaIndiceVoos(codVoo, listaVoos)).getDistancia();
                int categoria = cliente.getCategoria();
                if (categoria == 0) {
                    distancia = distancia * 0.621;
                }
                if (categoria == 1) {
                    distancia = (distancia * 0.621) * 1.5;
                }
                if (categoria == 2) {
                    distancia = (distancia * 0.621) * 2;
                }
            }
            String enderecoArquivoC = "D:\\Facul\\ControleMilhagem\\" + conjuge.getNome() + conjuge.getCodCli() + ".bin";
            listaVooClientes = ControledeMilhagem.leituramentoArquivo(listaVooClientes, enderecoArquivoC);
            for (Voocliente vCon : listaVooClientes) {
                int codVooC = vCon.getCodVoo();
                distanciaC += listaVoos.get(retornaIndiceVoos(codVooC, listaVoos)).getDistancia();
                int categoriaC = conjuge.getCategoria();
                if (categoriaC == 0) {
                    distanciaC = distanciaC * 0.621;
                }
                if (categoriaC == 1) {
                    distanciaC = (distanciaC * 0.621) * 1.5;
                }
                if (categoriaC == 2) {
                    distanciaC = (distanciaC * 0.621) * 2;
                }
            }
            //System.out.println("Distancia Cliente -> " + Math.ceil(distancia));
            //System.out.println("Distancia conjuge -> " + Math.ceil(distanciaC));
            System.out.println("=======================================");
            System.out.println("Saldo de Milhas familiar");
            System.out.println("=======================================");

            System.out.println("A soma da milhagem familiar é: " + Math.ceil(distancia + distanciaC));
            System.out.println("");
        }

    }

}
