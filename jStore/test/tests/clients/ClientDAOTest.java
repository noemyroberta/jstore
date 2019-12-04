package tests.clients;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
/**
 *
 * @author noemy
 */
public class ClientDAOTest {

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd_loja",
                "root", "");
    }
    
    @Before
    public void setUp() throws Exception {
        File xml = new File(getClass().getResource("client_data.xml").getFile());
        IDataSet dataset = new FlatXmlDataSetBuilder().build(xml);
        DatabaseConnection database = new DatabaseConnection(getConnection());
        DatabaseOperation.CLEAN_INSERT.execute(database, dataset);
    }
    
    @Test
    public void getAll() throws SQLException, ClassNotFoundException { 
        
    }
    
    @Test
    public void save() throws SQLException {
    
    }
}
