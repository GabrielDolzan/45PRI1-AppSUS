package Estrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para conexão com o banco
 * @author Gabriel Dolzan
 */
public class Conexao {

    private static Connection connection = null;
    static final String DB_URL = "jdbc:sqlite:banco-pri1.sqlite3";

    static final String USER = "sa";
    static final String PASS = "sa";

    public static Connection conectar() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void descontecar(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}