package br.com.ifal.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author noemy
 */
public class ConnectionFactory {
    
    public static String status = "Not connected";
    
    public ConnectionFactory() {
        
    }
    
    public static java.sql.Connection getConnectionFactory() {
        
        Connection connection = null;
        
        try {
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String serverName = "localhost";
            String database = "bd_loja";
            String url = "jdbc:mysql://" + serverName + "/" + database;
            String username = "root";
            String password = "";
            
            connection = DriverManager.getConnection(url, username, password);
            
            if (connection != null) 
                status = ("STATUS--->Successfully connected! :)");
            else 
                status = ("STATUS--->Connection not established :(");

            return connection;
        } catch (ClassNotFoundException ex) {
            System.err.println("Especified driver could not be found :( ");
            
            return null;
        } catch (SQLException ex) {
            System.err.println("Sorry, the database could not be found :( ");
            
            return null;
        }
    } 
    
    public static String getStatusConnection() {
        return status;
    }
    
    public static boolean closeConnection() {
        try {
            ConnectionFactory.getConnectionFactory().close();
            
            return true;
        } catch(SQLException e) {
            
            return false;
        }
    }
    
    public static java.sql.Connection restartConnection() {
        closeConnection();
        
        return ConnectionFactory.getConnectionFactory();
    }
}
