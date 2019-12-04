package br.com.ifal.daos;

import br.com.ifal.models.Clients;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author noemy
 */
public class ClientDAO {
    
    public void save(Clients client) {
        ConnectionFactory.getConnectionFactory();
        System.out.println(ConnectionFactory.getStatusConnection());
        
        String sql = "{ CALL sp_inserir_clientes(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement callStmt = null;
 
        try {
            callStmt = ConnectionFactory.getConnectionFactory().prepareCall(sql);
            
            callStmt.setString(1, client.getName());
            callStmt.setString(2, client.getCpf());
            callStmt.setString(3, client.getEmail());
            callStmt.setString(4, client.getBirthDate());
            callStmt.setString(5, client.getCellphone());
            callStmt.setString(6, client.getAddress().getCity());
            callStmt.setString(7, client.getAddress().getNeighborhood());
            callStmt.setString(8, client.getAddress().getStreet());
            callStmt.setInt(9, client.getAddress().getNumber());

            callStmt.execute();
            callStmt.close();
            
            ConnectionFactory.closeConnection();
            
            System.out.println("Successfully client saved! :)");
        } catch(SQLException ex) {
            System.err.println("Sorry, the client could not be saved :(");
            System.out.println(ex);
        }  
    }
 
}
