package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class ControleKart {

    public static ArrayList gravamentacaoArquivo(ArrayList arraylist, String enderecoArquivo) {
        try {
            FileOutputStream saida = new FileOutputStream(enderecoArquivo);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(saida);
            escritorObjetos.writeObject(arraylist);
            saida.close();
            System.out.println("Arquivo Gravado!!");
            return arraylist;
        } catch (Exception e) {
            System.out.println("ERRO!");
            return arraylist;
        }
    }

    public static ArrayList leituramentacaoArquivo(ArrayList arraylist, String enderecoArquivo) {
        try {
            InputStream entrada = new FileInputStream(enderecoArquivo);
            ObjectInputStream leitorObjetos = new ObjectInputStream(entrada);
            arraylist = (ArrayList) leitorObjetos.readObject();
            entrada.close();
            return arraylist;
        } catch (Exception e) {
            System.out.println("Erro");
            return arraylist;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Competidores> listacompetidores = new ArrayList();
        ArrayList<Classificacao> listacclassifica = new ArrayList();

//        listacclassifica = leituramentacaoArquivo(listacclassifica, Metodos.enderecoClassifica);
//        listacompetidores = leituramentacaoArquivo(listacompetidores, Metodos.enderecoCorredor);

        Metodos metodo = new Metodos();

        String opcao1, opcao2;

        metodo.Menuprincipal();
        opcao1 = scan.nextLine();

        while (!(opcao1).equals(
                "0")) {
            switch (opcao1) {
                case "1":
                    metodo.MenuCorredor();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {
                            case "1":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Cadastro de professor");
                                System.out.println("=======================================");
                                String nome;
                                int codigo;
                                float ponto;
                                System.out.println("Informe o nome do competidor");
                                nome = scan.nextLine();
                                System.out.println("Informe o codigo");
                                codigo = scan.nextInt();scan.nextLine();
                                System.out.println("Infome a classificação");
                                ponto = scan.nextFloat();
                                metodo.cadastroCompetidor(listacompetidores, codigo , nome, ponto);
                                metodo.limparTela();
                                break;

                            case "2":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Exclusão de professor");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo do professor ");
                                int codigo = scan.nextInt();
                                scan.nextLine();
                                metodo.EcluirProf(listaprof, codigo);
                                break;
                            case "3":
                                metodo.limparTela();

                                System.out.println("=======================================");
                                System.out.println("Lista de todos os professores");
                                System.out.println("=======================================");
                                metodo.ImprimeProf(listaprof, 0);
                                System.out.println("----------------------------------");
                                break;
                        }
                        metodo.MenuCorredor();
                        opcao2 = scan.nextLine();
                    }
                    metodo.Menuprincipal();
                    opcao1 = scan.nextLine();
                    break;
                case "2":
                    metodo.MenuChave();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {

                            case "1":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Cadastro de Chaves");
                                System.out.println("=======================================");
                                System.out.println("Informe o número do laboratorio");
                                int numLab = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Informe o codigo da chave");
                                int codChave = scan.nextInt();
                                scan.nextLine();
                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
                                metodo.CadastraChave(listachave, codChave, numLab);
                                break;

                            case "2":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Exclusão de chave");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo da chave a ser excluida");
                                codChave = scan.nextInt();
                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
                                metodo.ExluirChave(listachave, codChave);
                                System.out.println("");
                                System.out.println("=======================================");
                                System.out.println("Chave excluida com sucesso");
                                System.out.println("=======================================");

                                break;

                            case "3":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Lista de chaves cadastradas");
                                System.out.println("=======================================");
                                System.out.println("");
                                metodo.ImprimeChave(listachave);
                                System.out.println("");
                                System.out.println("=======================================");
                                System.out.println("FIM DA LISTA DE VOOS");
                                System.out.println("=======================================");
                                System.out.println("");
                                break;

                        }
                        metodo.MenuChave();
                        opcao2 = scan.nextLine();
                    }
                    metodo.MenuPrincipal();
                    opcao1 = scan.nextLine();
                    break;
                case "3":
                    metodo.MenuReserva();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {

                            case "1":

                                metodo.limparTela();
                                listaprof = leituramentoArquivo(listaprof, metodo.enderecoProfessor);
                                metodo.ImprimeProf(listaprof, 0);
                                System.out.println("Infome o codigo do professor");
                                int codigo = scan.nextInt();
                                Professor auxprof = new Professor();
                                auxprof = listaprof.get(Metodos.retornaIndiceProfessor(codigo, listaprof));
                                metodo.limparTela();

                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
                                metodo.ImprimeChave(listachave);
                                System.out.println("informe o codigo da chave");
                                codigo = scan.nextInt();
                                scan.nextLine();
                                Chave chave = new Chave();
                                chave = listachave.get(Metodos.retornaIndiceChave(codigo, listachave));
                                System.out.println("Informe o dia da semana");
                                int data = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Infome a hora ");
                                int hora = scan.nextInt();
                                scan.nextLine();
                                metodo.CadastroReserva(auxprof, chave, data, hora);

                                break;

                            case "2":
                                listaprof = leituramentoArquivo(listaprof, metodo.enderecoProfessor);
                                metodo.limparTela();
                                metodo.ImprimeProf(listaprof, 0);
                                break;

                            case "3":
                                listaprof = leituramentoArquivo(listaprof, metodo.enderecoProfessor);
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Lista de professores");
                                System.out.println("=======================================");
                                metodo.ImprimeProf(listaprof, 0);
                                System.out.println("=======================================");
                                System.out.println("Histórico de reservas por professor");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo do professor");
                                codigo = scan.nextInt();
                                scan.nextLine();
                                new Thread().sleep(1000);
                                metodo.HistoricoReserva(listaprof, codigo);
                                new Thread().sleep(5000);
                                System.out.println("");
                                System.out.println("FIM DA LISTA");
                                System.out.println("");
                                String escolha;
                                System.out.println("Deseja continuar?");
                                escolha = scan.nextLine();
                                if (!(escolha).equals("s")) {
                                    break;
                                }
                                break;
                        }
                        metodo.MenuReserva();
                        opcao2 = scan.nextLine();
                    }
                    metodo.MenuPrincipal();
                    opcao1 = scan.nextLine();
                    break;
            }

        }

    }

}
