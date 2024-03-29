/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lucas
 */
public class Jogador {

    String nome, apelido, email, telefone, personagem;
    double recompensa;
    int rodada;
    boolean jogador_da_rodada, vencedor; // Seta true ou false para saber quem inicio o jogo
    private static Jogador instance, instancej2;

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }

    public int getRodada() {
        return rodada;
    }

    //Contador de rodadas, utilizado para aumentar a recompensa
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    // Construtor privado (suprime o construtor público padrão).
    private Jogador() {
    }

    // Método público estático de acesso único ao objeto!
    public static Jogador getInstance() {
        return instance;
    }

    //Pegando valores do jogador dois
    public static Jogador getInstance2() {
        return instancej2;
    }

    public static Jogador CreateInstance() {
        if (instance == null) {
            return instance = new Jogador();
        } else {
            return instancej2 = new Jogador();
        }
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean GetJogadorRodada() {
        return jogador_da_rodada;
    }

    public void setJogadorRodada(boolean jogador_da_rodada) {
        this.jogador_da_rodada = jogador_da_rodada;
    }

    public double ComprarVida(double recompensa) {
        double nova_vida = 0, numero_vidas = 0;
        numero_vidas = recompensa / 50;
        nova_vida = numero_vidas * 10;
        recompensa = recompensa - (numero_vidas * 50);
        this.recompensa = recompensa; // Setando o que sobrou da recompensa do jogador
        return nova_vida;
    }
}
