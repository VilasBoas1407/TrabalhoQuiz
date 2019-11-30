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
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Classes.Usuario;

/**
 *
 * @author Lucas
 */
public class UsuarioDAO {

    private Connection connection;
    private int idC;
    private String cpfC, nomeC, rgC, telefoneC, emailC;
    PreparedStatement ps;

    public UsuarioDAO() {
        this.connection = null;
        this.ps = null;
    }

    public ArrayList ListarUsuarios() {
        String sql = "SELECT * FROM Usuario";
        ArrayList<Usuario> listUsuarios = new ArrayList();
        ResultSet rset = null;

        try {
            this.connection = (Connection) new ConnectionFactory().getConnection();
            ps = connection.prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()) {
                Usuario u = new Usuario();
                u.setId(rset.getInt("ID"));
                u.setNome(rset.getString("NOME"));
                u.setLogin(rset.getString("LOGIN"));
                u.setSenha(rset.getString("SENHA"));
                u.setFl_admin(rset.getBoolean("FL_ADMIN"));
                listUsuarios.add(u);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler clientes no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão do banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listUsuarios;
    }

    public Usuario VerificaLogin(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE LOGIN =" + login +" AND SENHA = " + senha;
        Usuario user = new Usuario();
        ResultSet rset = null;

        try {
            this.connection = (Connection) new ConnectionFactory().getConnection();
            ps = connection.prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()) {
                Usuario u = new Usuario();
                u.setId(rset.getInt("ID"));
                u.setNome(rset.getString("NOME"));
                u.setLogin(rset.getString("LOGIN"));
                u.setSenha(rset.getString("SENHA"));
                u.setFl_admin(rset.getBoolean("FL_ADMIN"));
                user = u;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler clientes no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão do banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return user;
    }
}
