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
public class Jogo {
  private static int rodada, rod_perguntas;   

    public static int getRod_perguntas() {
        return rod_perguntas;
    }

    public static void setRod_perguntas(int rod_perguntas) {
        Jogo.rod_perguntas = rod_perguntas;
    }
 // Para buscar as perguntas a rodada vai ser rodada - 1
    public static int getRodada() {
        return rodada;
    }

    public static void setRodada(int rodada) {
        Jogo.rodada = rodada;
    }
}
