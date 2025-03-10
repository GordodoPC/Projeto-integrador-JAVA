import java.sql.Connection;

import Conexao.ConexaoBD;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = ConexaoBD.conectar();
        if (conn != null) {
            System.out.println("Conexão realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
