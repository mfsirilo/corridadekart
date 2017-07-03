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

        listacclassifica = leituramentacaoArquivo(listacclassifica, Metodos.enderecoClassifica);
        listacompetidores = leituramentacaoArquivo(listacompetidores, Metodos.enderecoCorredor);

        Metodos metodos = new Metodos();

        int opcao1, opcao2;
        
        metodos.Menuprincipal();
        opcao1 = scan.nextInt();
        scan.nextLine();

    }

}
