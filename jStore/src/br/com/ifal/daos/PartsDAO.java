/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifal.daos;

import br.com.ifal.models.Parts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noemy
 */
public class PartsDAO {

    public void save(Parts part) {
        ConnectionFactory.getConnectionFactory();
        System.out.println(ConnectionFactory.getStatusConnection());

        String sql = "INSERT INTO tb_pecas(pec_descricao, pec_numero_serie, "
                + "pec_fabricante, pec_geracao, pec_preco, pec_estoque) "
                + "VALUES(?, ?, ?, ?, ?, ?);";

        PreparedStatement pstmt;
        try {
            pstmt = ConnectionFactory.getConnectionFactory().prepareStatement(sql);

            pstmt.setString(1, part.getDescription());
            pstmt.setString(2, part.getSerialNumber());
            pstmt.setString(3, part.getManufacturer());
            pstmt.setString(4, part.getGeneration());
            pstmt.setFloat(5, part.getPrice());
            pstmt.setString(6, part.getStock());

            pstmt.execute();
            pstmt.close();

            ConnectionFactory.getConnectionFactory().close();
            System.out.println("Sucessfully parts saved! :)");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Sorry, the parts could not be saved :(");
        }
    }

    public List<Parts> getAll() {
        List<Parts> parts = new ArrayList<>();
        String sql = "SELECT * FROM tb_pecas;";
        PreparedStatement pstmt;

        try {
            pstmt = ConnectionFactory.getConnectionFactory().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String desc = resultSet.getString("pec_descricao");
                String serialNumber = resultSet.getString("pec_numero_serie");
                String manufacturer = resultSet.getString("pec_fabricante");
                String generation = resultSet.getString("pec_geracao");
                Float price = resultSet.getFloat("pec_preco");
                String stock = resultSet.getString("pec_estoque");
                
                parts.add(new Parts(desc, serialNumber, manufacturer, generation, price, stock));
            }

            pstmt.close();
            ConnectionFactory.getConnectionFactory().close();
        } catch (SQLException ex) {
            System.err.println("An error occurred trying to list parts.");
            System.out.println(ex);
        }

        return parts;
    }

}
