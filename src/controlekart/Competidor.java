package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Competidor implements Serializable {

    private int codCom;
    private String nome;
    private float ponto;
    private int numClassificacao;
    private int tempo;

   

    Competidor() {
    }

    public Competidor(int codCom, String nome, float ponto, int numClassificacao, int tempo) {
        this.codCom = codCom;
        this.nome = nome;
        this.ponto = ponto;
        this.numClassificacao = numClassificacao;
        this.tempo = tempo;
    }

    public int getCodCom() {
        return codCom;
    }

    public void setCodCom(int codCom) {
        this.codCom = codCom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPonto() {
        return ponto;
    }

    public void setPonto(float ponto) {
        this.ponto = ponto;
    }

    public int getNumClassificacao() {
        return numClassificacao;
    }

    public void setNumClassificacao(int numClassificacao) {
        this.numClassificacao = numClassificacao;
    }
     public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


}
