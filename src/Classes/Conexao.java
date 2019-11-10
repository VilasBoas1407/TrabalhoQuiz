/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    //Variáveis de Conexão com o MySql
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    //Argumentos do driver de Conexão
    String url = "https://databases-auth.000webhost.com/db_structure.php?server=1&db=id11534807_bd_quiz";
    String user ="id11534807_admin";
    String password ="123456";
    String driver = "com.mysql.jbc.Driver";
    
    public void openConnectionMySql(){
    
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url,user,password);
            // Cria uma variável Statement
            stmt = con.createStatement();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na conexão com o bando de dados","ERRO",JOptionPane.ERROR_MESSAGE,null);
        
        }//Fim do Catch
    }//Fim do Método que abre a conexão com o MySql
}// Fim class public
