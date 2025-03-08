package projeto.dao;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class GenericDao<E, K> {
    // Atributos de Conexão com Banco de dados Mysql!
    private static final String url = "jdbc:mysql://localhost:3306/sistema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection conn;

    // Metodos de Conexão com Banco!
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

    // Metodo para pegar stattment!
    protected Statement getStatement() throws Exception {

        return getConnect().createStatement();

    }

    // Metodos fechar Statment!
    protected void closeStatment(java.sql.Statement st) throws Exception {
        if (st != null && !st.isClosed()) {

            st.close();
        }

    }

    public abstract void incluir(E entidadE);

    public abstract void alterar(E entidade);

    public abstract List<E> ObterTodos();
}
