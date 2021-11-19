/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Estrutura.Conexao;
import Modelo.ModeloAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DAOAdministrador {

    private static List<ModeloAdministrador> administradores = new ArrayList<>();

    public DAOAdministrador() {
        criaTabela();
    }

    public static boolean gravar(ModeloAdministrador administrador){
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO ADMINISTRADOR (cpf, nome, email, senha) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, administrador.getCpf());
            pstmt.setString(2, administrador.getNome());
            pstmt.setString(3, administrador.getEmail());
            pstmt.setString(4, administrador.getSenha());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 19) {
                JOptionPane.showMessageDialog(null, "Já existe um usuário cadastrado com este CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        } finally {
            Conexao.descontecar();
        }

        /*for (ModeloAdministrador admin : administradores){
            if(admin.getNome().equals(administrador.getNome())){
                return false;
            }
        }
        administradores.add(administrador);
        return true;*/
    }

    public static List<ModeloAdministrador> getAdministrador() {
        List<ModeloAdministrador> admin = null;
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM ADMINISTRADOR";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");

                admin.add(new ModeloAdministrador(email, nome, senha, cpf));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return admin;

        //return administradores;
    }

    public ModeloAdministrador getAdministrador(String cpf) {
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM ADMINISTRADOR WHERE cpf = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");

                return new ModeloAdministrador(email, nome, senha, cpf);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return null;

        //return administradores;
    }

    public static boolean removeAdministrador(String nome){
        for (ModeloAdministrador admin : administradores) {
            if (admin.getNome().equals(nome)) {
                administradores.remove(admin);
                return true;
            }
        }
        return false;
    }

    /**
     * Cria a tabela se não existe
     */
    private void criaTabela() {
        Connection connection = Conexao.conectar();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS ADMINISTRADOR"
                + "  ("
                + "   cpf         VARCHAR(11) PRIMARY KEY,"
                + "   nome        VARCHAR(255),"
                + "   email       VARCHAR(255),"
                + "   senha       VARCHAR(255)"
                + "  )";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.descontecar();
        }
    }

}
