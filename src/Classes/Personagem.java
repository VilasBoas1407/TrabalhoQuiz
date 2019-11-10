/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Lucas
 */
public class Personagem {
    Jogador j =  Jogador.getInstance();
    String nome;
    double vida;
    private static Personagem instance2;

    // Construtor privado (suprime o construtor público padrão).
    private Personagem() {}

    // Método público estático de acesso único ao objeto!
    public static Personagem getInstance() {
        return instance2;
    }
    
    public static Personagem CreateInstance(){
        return instance2 = new Personagem();
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
    
}
