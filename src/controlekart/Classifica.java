package controlekart;

import java.io.*;
import java.util.*;
import java.text.*;

public class Classifica implements Serializable {

    private int CodCorrida;
    private int CodCompetidor;
    private String localCorrida;
    private Competidor Array;
    //private float pontosCompetidor;

    Classifica() {
    }

    public Classifica(int CodCorrida, String localCorrida, Competidor Array) {
        this.CodCorrida = CodCorrida;
        //this.CodCompetidor = CodCompetidor;
        this.localCorrida = localCorrida;
        this.Array = Array;
    }

    public Competidor getArray() {
        return Array;
    }

    public void setArray(Competidor Array) {
        this.Array = Array;
    }

    public int getCodCorrida() {
        return CodCorrida;
    }

    public void setCodCorrida(int CodCorrida) {
        this.CodCorrida = CodCorrida;
    }

    public int getCodCompetidor() {
        return CodCompetidor;
    }

    public void setCodCompetidor(int CodCompetidor) {
        this.CodCompetidor = CodCompetidor;
    }

    public String getLocalCorrida() {
        return localCorrida;
    }

    public void setLocalCorrida(String localCorrida) {
        this.localCorrida = localCorrida;
    }

//    public float getPontosCompetidor() {
//        return pontosCompetidor;
//    }
//
//    public void setPontosCompetidor(float pontosCompetidor) {
//        this.pontosCompetidor = pontosCompetidor;
//    }

}
