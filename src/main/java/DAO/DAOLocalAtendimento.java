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

public class DAOLocalAtendimento {

    private static List<ModeloLocalAtendimento> locais = new ArrayList<>();

    public DAOLocalAtendimento() {
        criaTabela();
    }

    public static boolean salvar(ModeloLocalAtendimento local){
        locais.add(local);
        System.out.println(locais);
        return true;
    }

   public static List<ModeloLocalAtendimento> getLocalAtendimento(){
        return locais;

        /*List<ModeloLocalAtendimento> local = new ArrayList();
        Connection connection = Conexao.conectar();

        String sql = "SELECT * FROM ESPECIALIDADE";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");

                local.add(new ModeloLocalAtendimento(telefone, endereco));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            Conexao.descontecar();
        }

        return local;*/
    }

    public static boolean excluirFilial(String endereco){
        for(ModeloLocalAtendimento loc : locais){
            if(loc.getEndereco().equals(endereco)){
                locais.remove(loc);
                return true;
            }
        }
        return false;
    }

    public boolean insere(ModeloLocalAtendimento local) {
        Connection connection = Conexao.conectar();

        String sql = "INSERT INTO LOCALATENDIMENTO (endereco, telefone) VALUES(?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, local.getEndereco());
            pstmt.setString(2, local.getTelefone());

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
        String sqlCreate = "CREATE TABLE IF NOT EXISTS LOCALATENDIMENTO"
                + "  ("
                + "   id        INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   endereco  VARCHAR(255),"
                + "   telefone  SMALLINT"
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
