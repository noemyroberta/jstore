package br.com.ifal.daos;

import br.com.ifal.models.Procedures;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noemy
 */
public class ProcedureDAO {

    public void save(Procedures procedure) {

        Connection conn = ConnectionFactory.getConnectionFactory();
        System.out.println(ConnectionFactory.getStatusConnection());

        String sql = "INSERT INTO tb_procedimentos("
                + "pro_descricao, pro_preco, pro_equipamentos)"
                + "VALUES(?, ?, ?)";

        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, procedure.getDescription());
            pstmt.setString(2, Float.toString(procedure.getPrice()));
            pstmt.setString(3, procedure.getEquipment());

            pstmt.execute();
            pstmt.close();

            conn.close();
            System.out.println("Sucessfully procedure saved! :)");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Sorry, the procedure could not be saved :(");
        }
    }
    
    public List<Procedures> getAll() {
        List<Procedures> procedures = new ArrayList<>();
        String sql = "SELECT * FROM tb_procedimentos;";
        PreparedStatement pstmt;
        
        try {
            pstmt = ConnectionFactory.getConnectionFactory().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()) {
                String desc = resultSet.getString("pro_descricao");
                Float price = Float.parseFloat(resultSet.getString("pro_valor"));
                String equipment = resultSet.getString("pro_equipamentos");
                procedures.add(new Procedures(desc, price, equipment));
            }
            
            pstmt.close();
            ConnectionFactory.getConnectionFactory().close();
        } catch (SQLException ex) {
            System.err.println("An error occurred trying to list procedures.");
            System.out.println(ex);
        }
        
        return procedures;
    }

}
