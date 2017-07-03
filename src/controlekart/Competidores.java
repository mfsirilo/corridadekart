package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Competidores {
    private int codCom;
    private String nome;
    private float ponto;

    public Competidores(int codCom, String nome, float ponto) {
        this.codCom = codCom;
        this.nome = nome;
        this.ponto = ponto;
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
    
    
}
