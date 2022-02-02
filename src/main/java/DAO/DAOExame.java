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

public class DAOExame {

    private static List<ModeloExame> exames = new ArrayList<>();

    public DAOExame() {
        criaTabela();
    }

    public static boolean gravar(ModeloExame exame){
        exames.add(exame);
        return true;
    }

    public static List<ModeloExame> getExame() {
        List<ModeloExame> exames = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM EXAME";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");
                Integer tipo = resultado.getInt("tipo");
                String usuario = resultado.getString("usuario");
                Integer local = resultado.getInt("local");

                ModeloUsuario Usuario = DAOUsuario.getUsuario(usuario);
                ModeloTipoExame TipoExame = DAOTipoExame.getTipoExame(tipo);
                ModeloLocalAtendimento Local = DAOLocalAtendimento.getLocalAtendimento(local);

                ModeloExame Exame = new ModeloExame(data, hora, Usuario, TipoExame, Local);
                Exame.setId(id);

                exames.add(Exame);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return exames;

        //return exames;
    }

    public static ModeloExame getProximoExame(ModeloUsuario usuario) {
        ModeloExame exame = null;
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM EXAME WHERE usuario = ? ORDER BY DATA DESC, HORA DESC LIMIT 1";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getCpf());

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");
                Integer tipo = resultado.getInt("tipo");
                Integer local = resultado.getInt("local");

                ModeloTipoExame TipoExame = DAOTipoExame.getTipoExame(tipo);
                ModeloLocalAtendimento Local = DAOLocalAtendimento.getLocalAtendimento(local);

                exame = new ModeloExame(data, hora, usuario, TipoExame, Local);
                exame.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return exame;

        //return exames;
    }

    public static List<ModeloExame> getExameLivre(ModeloTipoExame tipo, ModeloLocalAtendimento local) {
        List<ModeloExame> exames = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM EXAME WHERE tipo = ? and local = ? and usuario is null";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, tipo.getId());
            pstmt.setInt(2, local.getId());

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String data = resultado.getString("data");
                String hora = resultado.getString("hora");

                ModeloExame exame = new ModeloExame(data, hora, null, tipo, local);
                exame.setId(id);

                exames.add(exame);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return exames;
    }

    public static List<ModeloExame> getExameLivre(ModeloTipoExame tipo, ModeloLocalAtendimento local, String data) {
        List<ModeloExame> exames = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM EXAME WHERE tipo = ? and local = ? and data = ? and usuario is null";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, tipo.getId());
            pstmt.setInt(2, local.getId());
            pstmt.setString(3, data);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String hora = resultado.getString("hora");

                ModeloExame exame = new ModeloExame(data, hora, null, tipo, local);
                exame.setId(id);

                exames.add(exame);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return exames;
    }

    public boolean agendarExame(ModeloExame exame) {
        Connection connection = Conexao.conectar();

        String sql = "UPDATE EXAME SET usuario = " + exame.getUsuario().getCpf() + " WHERE tipo = ? AND local = ? AND data = ? AND hora = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, exame.getTipoExame().getId());
            pstmt.setInt(2, exame.getLocal().getId());
            pstmt.setString(3, exame.getData());
            pstmt.setString(4, exame.getHora());

            pstmt.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            Conexao.descontecar();
        }
    }

    public boolean insere(ModeloExame exame) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO EXAME (data, hora, tipo, local) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, exame.getData());
            pstmt.setString(2, exame.getHora());
            pstmt.setInt(3, exame.getTipoExame().getId());
            pstmt.setInt(4, exame.getLocal().getId());

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
        String sqlCreate = "CREATE TABLE IF NOT EXISTS EXAME"
                + "  ("
                + "   id       INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   data     DATE,"
                + "   hora     VARCHAR(5),"
                + "   tipo     INTEGER,"
                + "   usuario  VARCHAR(11),"
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

    public static boolean excluirExame(String DAta, String Hora){
        for(ModeloExame f : exames){
            if(f.getData().equals(DAta) && f.getHora().equals(Hora)){
                exames.remove(f);
                return true;
            }
        }
        return false;
    }
}
