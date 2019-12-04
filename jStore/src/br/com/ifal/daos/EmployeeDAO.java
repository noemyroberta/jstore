package br.com.ifal.daos;

import br.com.ifal.models.Employees;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noemy
 */
public class EmployeeDAO {

    public void save(Employees employee) {

        ConnectionFactory.getConnectionFactory();
        System.out.println(ConnectionFactory.getStatusConnection());

        String sql = "{ CALL sp_inserir_funcionarios(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement callStmt;

        try {
            callStmt = ConnectionFactory.getConnectionFactory().prepareCall(sql);

            callStmt.setString(1, employee.getName());
            callStmt.setString(2, employee.getCpf());
            callStmt.setString(3, employee.getEmail());
            callStmt.setString(4, employee.getBirthDate());
            callStmt.setString(5, employee.getCellphone());
            callStmt.setString(6, employee.getAddress().getCity());
            callStmt.setString(7, employee.getAddress().getNeighborhood());
            callStmt.setString(8, employee.getAddress().getStreet());
            callStmt.setInt(9, employee.getAddress().getNumber());
            callStmt.setString(10, employee.getUsername());
            callStmt.setString(11, employee.getPassword());
            callStmt.setString(12, employee.getFunction());

            callStmt.execute();
            callStmt.close();

            ConnectionFactory.closeConnection();

            System.out.println("Successfully employee saved! :)");
        } catch (SQLException ex) {
            System.err.println("Sorry, the employee could not be saved :(");
            System.out.println(ex);
        }
    }

    public boolean verifyLogin(Employees employee) {
        boolean auth = false;
        String sql = "SELECT fun_id, fun_nome_usuario, fun_senha"
                + "FROM tb_funcionarios "
                + "WHERE fun_nome_usuario = ? "
                + "AND fun_senha = ?;";

        ConnectionFactory.getConnectionFactory();
        System.out.println(ConnectionFactory.getStatusConnection());

        PreparedStatement pstmt;

        try {
            pstmt = ConnectionFactory.getConnectionFactory().prepareStatement(sql);
            pstmt.setString(1, employee.getUsername());
            pstmt.setString(2, employee.getPassword());
            
            ResultSet resultSet = pstmt.executeQuery();
            
            if(resultSet.next()) {
                auth = true;
            } else {
                pstmt.close();
                return auth;
            }
            
            System.out.println(employee.toString());     
        } catch (SQLException ex) {
            System.err.println("Employee not found :(");
            System.out.println(ex);
        }
        
        return auth;
    }
}
