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

        ArrayList<Competidor> listacompetidores = new ArrayList();
        ArrayList<Classifica> listacclassifica = new ArrayList();

        listacclassifica = leituramentacaoArquivo(listacclassifica, Metodos.enderecoClassifica);
        listacompetidores = leituramentacaoArquivo(listacompetidores, Metodos.enderecoCompetidor);

        Metodos metodo = new Metodos();

        String opcao1, opcao2;

        metodo.Menuprincipal();
        opcao1 = scan.nextLine();

        while (!(opcao1).equals(
                "0")) {
            switch (opcao1) {
                case "1":
                    metodo.MenuCompetidor();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {
                            case "1":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Cadastro de Competidor");
                                System.out.println("=======================================");
                                String nome;
                                System.out.println("Informe o nome do competidor");
                                nome = scan.nextLine();
                                metodo.cadastroCompetidor(listacompetidores, nome, 0, 0);
                                metodo.limparTela();
                                break;

                            case "2":
                                metodo.limparTela();
                                int codigo;
                                System.out.println("=======================================");
                                System.out.println("Exclusão de competidor");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo do competidor ");
                                codigo = scan.nextInt();
                                scan.nextLine();
                                metodo.ExcluirCorredor(listacompetidores,codigo);
                                break;
                            case "3":
                                metodo.limparTela();

                                System.out.println("=======================================");
                                System.out.println("Lista de todos os professores");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo do competidor ou\n"
                                        + "Informe 99 para imprimir todos os competidores");
                                codigo = scan.nextInt();
                                metodo.ImprimeCorredor(listacompetidores, codigo);
                                System.out.println("----------------------------------");
                                break;
                        }
                        metodo.MenuCompetidor();
                        opcao2 = scan.nextLine();
                    }
                    metodo.Menuprincipal();
                    opcao1 = scan.nextLine();
                    break;
                case "2":
                    metodo.MenuCorrida();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {

//                            case "1":
//                                metodo.limparTela();
//                                System.out.println("=======================================");
//                                System.out.println("Cadastro de Chaves");
//                                System.out.println("=======================================");
//                                System.out.println("Informe o número do laboratorio");
//                                int numLab = scan.nextInt();
//                                scan.nextLine();
//                                System.out.println("Informe o codigo da chave");
//                                int codChave = scan.nextInt();
//                                scan.nextLine();
//                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
//                                metodo.CadastraChave(listachave, codChave, numLab);
//                                break;
//
//                            case "2":
//                                metodo.limparTela();
//                                System.out.println("=======================================");
//                                System.out.println("Exclusão de chave");
//                                System.out.println("=======================================");
//                                System.out.println("Informe o codigo da chave a ser excluida");
//                                codChave = scan.nextInt();
//                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
//                                metodo.ExluirChave(listachave, codChave);
//                                System.out.println("");
//                                System.out.println("=======================================");
//                                System.out.println("Chave excluida com sucesso");
//                                System.out.println("=======================================");
//
//                                break;
//
//                            case "3":
//                                metodo.limparTela();
//                                System.out.println("=======================================");
//                                System.out.println("Lista de chaves cadastradas");
//                                System.out.println("=======================================");
//                                System.out.println("");
//                                metodo.ImprimeChave(listachave);
//                                System.out.println("");
//                                System.out.println("=======================================");
//                                System.out.println("FIM DA LISTA DE VOOS");
//                                System.out.println("=======================================");
//                                System.out.println("");
//                                break;

                        }
                        metodo.MenuCorrida();
                        opcao2 = scan.nextLine();
                    }
                    metodo.Menuprincipal();
                    opcao1 = scan.nextLine();
                    break;
            }
        }
    }
}