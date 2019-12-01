/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Perguntas {

    private int ID;
    private String Enunciado, solucao;
     private List<Respostas> r = new ArrayList<Respostas>();

    public List<Respostas> getR() {
        return r;
    }

    public void setR(List<Respostas> r) {
        this.r = new ArrayList<Respostas>();
        this.r = r;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEnunciado() {
        return Enunciado;
    }

    public void setEnunciado(String Enunciado) {
        this.Enunciado = Enunciado;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }




}
