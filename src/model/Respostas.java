/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class Respostas {

    public int ID_ALTERNATIVA, ID_QUESTAO;
    public String DS_ALTERNATIVA, ALTERNATIVA;
    private static Respostas instance;

    public static Respostas getInstance() {
        return instance;
    }

    public int getID_ALTERNATIVA() {
        return ID_ALTERNATIVA;
    }

    public void setID_ALTERNATIVA(int ID_ALTERNATIVA) {
        this.ID_ALTERNATIVA = ID_ALTERNATIVA;
    }

    public int getID_QUESTAO() {
        return ID_QUESTAO;
    }

    public void setID_QUESTAO(int ID_QUESTAO) {
        this.ID_QUESTAO = ID_QUESTAO;
    }

    public String getDS_ALTERNATIVA() {
        return DS_ALTERNATIVA;
    }

    public void setDS_ALTERNATIVA(String DS_ALTERNATIVA) {
        this.DS_ALTERNATIVA = DS_ALTERNATIVA;
    }

    public String getALTERNATIVA() {
        return ALTERNATIVA;
    }

    public void setALTERNATIVA(String ALTERNATIVA) {
        this.ALTERNATIVA = ALTERNATIVA;
    }

}
