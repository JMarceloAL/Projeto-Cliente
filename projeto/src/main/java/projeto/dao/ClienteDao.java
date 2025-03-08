package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.object.Cliente;

public class ClienteDao extends GenericDao<Cliente, String> {
    // Metodo para Listar Dados do Banco de Dados!
    @Override
    public List<Cliente> ObterTodos() { 
        List<Cliente> lista = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnect();
            String query = "SELECT * FROM CLIENTES ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setNumero(rs.getString("telefone"));
                lista.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeResources(rs, ps, conn);
        }
        return lista;

    }
    //Fechar Conexão!
    private void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Inserir Dados!
    @Override
    public void incluir(Cliente cliente) {

        try {
            String query = "INSERT INTO CLIENTES ( nome,cpf,email,telefone) VALUES (?,?,?,?)";
            PreparedStatement ps = getConnect().prepareStatement(query);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getNumero());

            ps.executeUpdate();
            closeStatment(ps);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    //Excluir Dados!
    public void excluir(int codigo) {
        Connection c1 = null;
        try {
            String query = "DELETE  FROM CLIENTES  WHERE id = ?";
            c1 = getConnect();
            c1.setAutoCommit(false);
            PreparedStatement ps = getConnect().prepareStatement(query);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            c1.commit();

        } catch (Exception e) {
            if (c1 != null)

                try {
                    c1.rollback();
                    c1.close();
                } catch (SQLException e2) {
                }
        }

    }
    //Alterar Dados!
    @Override
    public void alterar(Cliente cliente) {

        try {

            PreparedStatement ps = getConnect()
                    .prepareStatement("UPDATE CLIENTES SET NOME = ?, CPF = ?, EMAIL = ? , TELEFONE = ? WHERE ID = ?");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getNumero());
            ps.setLong(5, cliente.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
