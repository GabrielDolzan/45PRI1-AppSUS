package DAO;

import Estrutura.Conexao;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOEspecialidade {

    private static List<ModeloEspecialidade> especialidades = new ArrayList<>();

    public DAOEspecialidade() {
        criaTabela();
    }

    public static boolean gravar(ModeloEspecialidade especialidade){
        for (ModeloEspecialidade esp: especialidades) {
            if(esp.getDescricao().equalsIgnoreCase(especialidade.getDescricao())){
                return false;
            }
        }
        especialidades.add(especialidade);
        System.out.println(especialidades);

        return true;
    }

    public boolean insere(ModeloEspecialidade modelo) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO ESPECIALIDADE (descricao) VALUES(?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modelo.getDescricao());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Conexao.descontecar();
        }
    }

    public static List<ModeloEspecialidade> getEspecialidade() {
        return especialidades;
/*
        List<ModeloEspecialidade> esp = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM ESPECIALIDADE";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String descricao = resultado.getString("descricao");

                esp.add(new ModeloEspecialidade(descricao));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return esp;*/
    }

    public void criaTabela() {
        Connection connection = Conexao.conectar();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS ESPECIALIDADE"
                + "  ("
                + "   id         INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   descricao  VARCHAR(255)"
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
