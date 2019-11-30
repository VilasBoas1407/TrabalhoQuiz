/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Lucas
 */

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/quizpoo";
    private static final String usuario = "root";
    private static final String senha = "vilas1407";

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("src.com.mysql.jdbc"); /* Aqui registra */
       
        try {
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }

}
