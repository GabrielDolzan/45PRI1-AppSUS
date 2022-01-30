package DAO;

import Estrutura.Conexao;
import Modelo.ModeloTipoExame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOTipoExame {

    private static List<ModeloTipoExame> exames = new ArrayList<>();

    public DAOTipoExame() {
        criaTabela();
    }

    public static boolean gravar(ModeloTipoExame exame){
        for(ModeloTipoExame ex: exames){
            if(ex.getDescricao().equalsIgnoreCase(exame.getDescricao())){
                return false;
            }
        }
        exames.add(exame);
        System.out.println(exames);

        return true;
    }

    public boolean insere(ModeloTipoExame exame) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO TIPOEXAME (descricao) VALUES(?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, exame.getDescricao());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Conexao.descontecar();
        }
    }

    public static List<ModeloTipoExame> getTipoExame() {
        //return exames;

        List<ModeloTipoExame> tipo = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM TIPOEXAME";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String descricao = resultado.getString("descricao");

                ModeloTipoExame TipoExame = new ModeloTipoExame(descricao);
                TipoExame.setId(id);

                tipo.add(TipoExame);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return tipo;
    }

    public static ModeloTipoExame getTipoExame(Integer id) {
        ModeloTipoExame tipo = null;
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM TIPOEXAME WHERE id = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String descricao = resultado.getString("descricao");

                tipo = new ModeloTipoExame(descricao);
                tipo.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return tipo;
    }

    public void criaTabela() {
        Connection connection = Conexao.conectar();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS TIPOEXAME"
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