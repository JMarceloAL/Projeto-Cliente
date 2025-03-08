package projeto.Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectBD {

    private static final String url = "jdbc:mysql://localhost:3306/sistema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection conn;

    public static Connection getConnect() {

        try {
            if (conn == null || conn.isClosed()) {

                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado com Sucesso!");
            }
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro na Conexão!");
            return null;
        }

    }
}
