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
public class Personagem {

    Jogador j = Jogador.getInstance();
    String nome;
    double vida;
    private static Personagem personagem, personagem2;

    // Construtor privado (suprime o construtor público padrão).
    private Personagem() {
    }

    // Método público estático de acesso único ao objeto!
    public static Personagem getInstance() {
        return personagem;
    }

    // Retorna dados do personagem do Jogador 2
    public static Personagem getInstance2() {
        return personagem2;
    }

    public static Personagem CreateInstance() {
        if (personagem == null) {
            return personagem = new Personagem();
        } else {
            return personagem2 = new Personagem();
        }
    }

    public Jogador getJ() {
        return j;
    }

    public void setJ(Jogador j) {
        this.j = j;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public String GetPersonagem(String nomeP1) {
        //Fazer switch para pegar o personagem
        switch (nomeP1) {
            case "Blinky":
                break;
            case "Clyde":
                break;
            case "Pinky":
                break;
            case "Pac":
                break;
            case "Inky":
                break;
        }
        return null;
    }

}
