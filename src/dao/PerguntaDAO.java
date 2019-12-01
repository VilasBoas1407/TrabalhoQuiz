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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Perguntas;
import model.Respostas;

/**
 *
 * @author Lucas
 */
public class PerguntaDAO {

    public List<Perguntas> ListaPerguntas() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null, rp = null;

        List<Perguntas> perguntas = new ArrayList<>();
        List<Respostas> respostas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM perguntas");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Perguntas p = new Perguntas();
                p.setID(rs.getInt("ID"));
                p.setEnunciado(rs.getString("DS_ENUNCIADO"));
                p.setSolucao(rs.getString("DS_ALTERNATIVA"));
                perguntas.add(p);
            }
            return perguntas;
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return perguntas;

    }

    public List<Respostas> ListarRespostas(int ID_QUESTAO) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null, rp = null;

        List<Respostas> respostas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM respostas WHERE ID_QUESTAO = ? ");
            stmt.setInt(1, ID_QUESTAO);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Respostas r = new Respostas();
                r.setID_ALTERNATIVA(rs.getInt("ID_ALTERNATIVA"));
                r.setID_QUESTAO(rs.getInt("ID_QUESTAO"));
                r.setDS_ALTERNATIVA(rs.getString("DS_ALTERNATIVA"));
                r.setALTERNATIVA(rs.getString("ALTERNATIVA"));

                respostas.add(r);
            }
            return respostas;
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return respostas;

    }
}
