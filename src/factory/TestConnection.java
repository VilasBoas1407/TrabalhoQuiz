/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;
//import dao.ClienteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
//import model.Cliente;
/**
 *
 * @author Lucas
 */
public class TestConnection {
        public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {

        Connection connection = (Connection) new ConnectionFactory().getConnection();
        if (connection != null) {
            System.out.println("Conexão aberta!");
            connection.close();
        }
    }
}
