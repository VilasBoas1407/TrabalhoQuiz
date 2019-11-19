/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lucas
 */
public class Jogador {

    String nome, apelido, email, recompensa, telefone, personagem;
    boolean primeiro; // Seta true ou false para saber quem inicio o jogo

    private static Jogador instance, instancej2;

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

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
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

    public boolean GetPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(boolean primeiro) {
        this.primeiro = primeiro;
    }
}
