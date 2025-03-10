package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres2";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "293755";

    public ConexaoBD() {
    }

    public static Connection conectar() {
        try {
            // Adicione esta linha para carregar explicitamente o driver
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException var1) {
            System.out.println("Erro ao conectar: " + var1.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        }
    }
}