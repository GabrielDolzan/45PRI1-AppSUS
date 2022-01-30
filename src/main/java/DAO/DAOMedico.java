package DAO;

import Estrutura.Conexao;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOMedico {

    private static List<ModeloMedico> medicos = new ArrayList<>();

    public DAOMedico() {
        criaTabela();
    }

    public static boolean gravar(ModeloMedico medico){
//        for(ModeloMedico med : medicos){
//
//            System.out.println(med.getRg()+" xxxxxxxxxx "+ medico.getRg());
//
//            if(med.getRg().equals(medico.getRg())){
//                return false;
//            }
//        }
        medicos.add(medico);
        System.out.println(medicos);

        return true;
    }

    public static List<ModeloMedico> getMedico() {
        List<ModeloMedico> medicos = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM MEDICO";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String rg = resultado.getString("rg");
                Integer especialidade = resultado.getInt("especialidade");

                ModeloEspecialidade Especialidade = DAOEspecialidade.getEspecialidade(especialidade);

                ModeloMedico Medico = new ModeloMedico(nome, Especialidade, telefone, rg);
                Medico.setId(id);

                medicos.add(Medico);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return medicos;

        //return medicos;
    }

    public static ModeloMedico getMedico(Integer id) {
        ModeloMedico medico = null;
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM MEDICO WHERE id = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String rg = resultado.getString("rg");
                Integer especialidade = resultado.getInt("especialidade");

                ModeloEspecialidade Especialidade = DAOEspecialidade.getEspecialidade(especialidade);

                medico = new ModeloMedico(nome, Especialidade, telefone, rg);
                medico.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return medico;
    }

    public static boolean removeMedico(String nome){
        for(ModeloMedico med : medicos){
            if(med.getNome().equals(nome)){
                medicos.remove(med);
                return true;
            }
        }
        return false;
    }

    public boolean insere(ModeloMedico medico) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO MEDICO (nome, telefone, rg, especialidade) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getTelefone());
            pstmt.setString(3, medico.getRg());
            pstmt.setInt(4, medico.getEspecialidade().getId());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Conexao.descontecar();
        }
    }

    private void criaTabela() {
        Connection connection = Conexao.conectar();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS MEDICO"
                + "  ("
                + "   id            INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   nome          VARCHAR(255),"
                + "   telefone      VARCHAR(11),"
                + "   rg            VARCHAR(7),"
                + "   especialidade SMALLINT NOT NULL"
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
