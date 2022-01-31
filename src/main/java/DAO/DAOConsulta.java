package DAO;

import Estrutura.Conexao;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import Modelo.ModeloUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOConsulta {

    private static List<ModeloConsulta> consultas = new ArrayList<>();
    private static List<ModeloConsulta> copias = new ArrayList<>();

    public DAOConsulta() {
        criaTabela();
    }

    public static boolean gravar(ModeloConsulta consulta){
        consultas.add(consulta);
        return true;
    }

    public static boolean pesquisaData(ModeloConsulta consulta, ModeloConsulta copia){
        for (ModeloConsulta ex: consultas) {
            if(ex.getStatus().equalsIgnoreCase(consulta.getStatus())){
                copias.add(ex);
                return true;
            }
        }

        return false;
    }

    public static List<ModeloConsulta> getConsulta() {
        List<ModeloConsulta> consultas = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM CONSULTA";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");
                String usuario = resultado.getString("usuario");
                Integer medico = resultado.getInt("medico");
                Integer local = resultado.getInt("local");

                ModeloUsuario Usuario = DAOUsuario.getUsuario(usuario);
                ModeloMedico Medico = DAOMedico.getMedico(medico);
                ModeloLocalAtendimento Local = DAOLocalAtendimento.getLocalAtendimento(local);

                ModeloConsulta consulta = new ModeloConsulta(data, hora, Usuario, Medico, Local);
                consulta.setId(id);

                consultas.add(consulta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return consultas;
    }

    public static List<ModeloConsulta> getConsultaLivre(ModeloMedico medico, ModeloLocalAtendimento local) {
        List<ModeloConsulta> consultas = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM CONSULTA WHERE medico = ? AND local = ? AND usuario is null";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, medico.getId());
            pstmt.setInt(2, local.getId());

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");

                ModeloConsulta consulta = new ModeloConsulta(data, hora, null, medico, local);
                consulta.setId(id);

                consultas.add(consulta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return consultas;
    }

    public static List<ModeloConsulta> getConsultaLivre(ModeloMedico medico, ModeloLocalAtendimento local, String data) {
        List<ModeloConsulta> consultas = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM CONSULTA WHERE medico = ? AND local = ? AND data = ? AND usuario is null";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, medico.getId());
            pstmt.setInt(2, local.getId());
            pstmt.setString(3, data);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String hora = resultado.getString("hora");

                ModeloConsulta consulta = new ModeloConsulta(data, hora, null, medico, local);
                consulta.setId(id);

                consultas.add(consulta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return consultas;
    }

    public boolean agendarConsulta(ModeloConsulta consulta) {
        Connection connection = Conexao.conectar();

        String sql = "UPDATE CONSULTA SET usuario = " + consulta.getUsuario().getCpf() + " WHERE medico = ? AND local = ? AND data = ? AND hora = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, consulta.getMedico().getId());
            pstmt.setInt(2, consulta.getLocal().getId());
            pstmt.setString(3, consulta.getData());
            pstmt.setString(4, consulta.getHora());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            Conexao.descontecar();
        }
    }

    public ModeloConsulta getProximaConsulta(ModeloUsuario usuario) {
        ModeloConsulta consulta = null;
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM CONSULTA WHERE usuario = ? ORDER BY DATA DESC, HORA DESC LIMIT 1";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getCpf());

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");
                Integer medico = resultado.getInt("medico");
                Integer local = resultado.getInt("local");

                ModeloMedico Medico = DAOMedico.getMedico(medico);
                ModeloLocalAtendimento Local = DAOLocalAtendimento.getLocalAtendimento(local);

                consulta = new ModeloConsulta(data, hora, usuario, Medico, Local);
                consulta.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return consulta;
    }

    public Iterable<ModeloConsulta> getConsultaCopia(){
        return copias;
    }

    public boolean insere(ModeloConsulta consulta) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO CONSULTA (data, hora, medico, local) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, consulta.getData());
            pstmt.setString(2, consulta.getHora());
            pstmt.setInt(3, consulta.getMedico().getId());
            pstmt.setInt(4, consulta.getLocal().getId());

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
        String sqlCreate = "CREATE TABLE IF NOT EXISTS CONSULTA"
                + "  ("
                + "   id       INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   data     DATE,"
                + "   hora     VARCHAR(5),"
                + "   usuario  VARCHAR(11),"
                + "   medico   INTEGER,"
                + "   local    INTEGER"
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
    
     public static boolean excluirConsulta(String DAta, String Hora){
        for(ModeloConsulta f : consultas){
            if(f.getData().equals(DAta) && f.getHora().equals(Hora)){
                consultas.remove(f);
                return true;
            }
        }
        return false;
    }

}