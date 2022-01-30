package DAO;

import Estrutura.Conexao;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOUsuario {

    private static List<ModeloUsuario> usuarios = new ArrayList<>();

    public DAOUsuario() {
        criaTabela();
    }

    public boolean gravar(ModeloUsuario usuario) {
        for (ModeloUsuario use : usuarios) {
            if(use.getCpf().equals(usuario.getCpf())){
                return false;
            }
        }

        usuarios.add(usuario);

        return true;
    }

    /**
     * Insere o usuário
     * @param usuario
     * @return bool
     */
    public boolean insere(ModeloUsuario usuario) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO USUARIO (cpf, nome, email, senha, estado, cidade, celular, nascimento, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            String[] data = usuario.getNascimento().split("/");

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getCpf());
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getSenha());
            pstmt.setString(5, usuario.getEstado());
            pstmt.setString(6, usuario.getCidade());
            pstmt.setString(7, usuario.getCelular());
            //pstmt.setDate(8, Date.valueOf(data[2] + "-" + data[1] + "-" + data[0]));
            pstmt.setString(8, usuario.getNascimento());
            pstmt.setString(9, usuario.getSexo());

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
    }

    /**
     * Retorna todos os usuários
     * @return List<ModeloUsuario>
     */
    public List<ModeloUsuario> getUsuario() {
        List<ModeloUsuario> usu = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM USUARIO";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String celular = resultado.getString("celular");
                String nascimento = resultado.getString("nascimento");
                String sexo = resultado.getString("sexo");

                usu.add(new ModeloUsuario(estado, cidade, nome, cpf, celular, nascimento, sexo, email, senha));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return usu;

        //return usuarios;
    }

    /**
     * Retorna o usuário conforme cpf
     * @param cpf
     * @return ModeloUsuario
     */
    public static ModeloUsuario getUsuario(String cpf) {
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM USUARIO WHERE cpf = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cpf);

            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String celular = resultado.getString("celular");
                String nascimento = resultado.getString("nascimento");
                String sexo = resultado.getString("sexo");

                return new ModeloUsuario(estado, cidade, nome, cpf, celular, nascimento, sexo, email, senha);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return null;
    }

    /**
     * Remove o usuário conforme cpf
     * @param cpf
     * @return bool
     */
    public boolean removeUsuario(String cpf) {
        Connection connection = Conexao.conectar();

        String sql = "DELETE FROM USUARIO WHERE cpf = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cpf);
            pstmt.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Conexao.descontecar();
        }

        /*
        for(ModeloUsuario use : usuarios){
            if(use.getCpf().equals(cpf)){
                usuarios.remove(use);
                return true;
            }
        }
        return false;*/
    }

    /**
     * Cria a tabela se não existe
     */
    private void criaTabela() {
        Connection connection = Conexao.conectar();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS USUARIO"
                + "  ("
                + "   cpf         VARCHAR(11) PRIMARY KEY,"
                + "   nome        VARCHAR(255),"
                + "   email       VARCHAR(255),"
                + "   senha       VARCHAR(255),"
                + "   estado      VARCHAR(255),"
                + "   cidade      VARCHAR(255),"
                + "   celular     VARCHAR(11),"
                + "   nascimento  DATE,"
                + "   sexo        VARCHAR(255)"
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