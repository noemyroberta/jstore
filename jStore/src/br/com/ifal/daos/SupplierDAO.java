
package br.com.ifal.daos;

import br.com.ifal.models.Sectors;
import br.com.ifal.models.Suppliers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noemy
 */
public class SupplierDAO {
   
    public List<Suppliers> getAll() {
        List<Suppliers> suppliers = new ArrayList<>();
        
        String sql = ""
                + "SELECT F.for_nome_empresa AS nome_empresa, "
                + "       F.for_cnpj AS cnpj"
                + "       S.set_setor AS setor"
                + "FROM tb_fornecedores F"
                + "       INNER JOIN tb_setores S ON (F.fun_set_id = S.set_id);";
        PreparedStatement pstmt;
        
        try {
            pstmt = ConnectionFactory.getConnectionFactory().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()) {
                String company = resultSet.getString("nome_empresa");
                String cnpj = resultSet.getString("cnpj");
                Sectors sector = new Sectors(resultSet.getString("setor"));
                suppliers.add(new Suppliers(company, cnpj, sector));
            }
            
            pstmt.close();
            ConnectionFactory.getConnectionFactory().close();
        } catch (SQLException ex) {
            System.err.println("An error occurred trying to list suppliers.");
            System.out.println(ex);
        }
        
        return suppliers;
    }
}
