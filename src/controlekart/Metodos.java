package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Metodos {

    static String enderecoCorredor = "D:\\Facul\\ControleMilhagem\\corredor.bin";
    static String enderecoClassifica = "D:\\Facul\\ControleMilhagem\\classifica.bin";

    Scanner scan = new Scanner(System.in);

    public static void limparTela() {
        for (int i = 0; i != 20; ++i) {
            System.out.println("");
        }
    }

    public void MenuPrincipal() {
        System.out.println("=======================================");
        System.out.println("Menu principal ");
        System.out.println("=======================================");
        System.out.println("Informe uma opçcão de acordo com o Menu:");
        System.out.println("Digite 1 para Corredores");
        System.out.println("Digite 2 para Voos");
        System.out.println("Digite 3 para Relatórios");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
    }

}
