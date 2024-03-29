/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Lucas
 */
public class UsuarioDAO {

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE LOGIN = ? and SENHA = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public Usuario GetDados(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user = new Usuario();
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE LOGIN = ? and SENHA = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    user.setId(rs.getInt("ID"));
                    user.setNome(rs.getString("NOME"));
                    user.setLogin(rs.getString("LOGIN"));
                    user.setSenha(rs.getString("SENHA"));
                    user.setFl_admin(rs.getBoolean("FL_ADMIN"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return user;

    }
}
