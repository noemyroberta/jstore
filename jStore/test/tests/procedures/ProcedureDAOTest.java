package tests.procedures;

import static br.com.ifal.daos.ConnectionFactory.getConnectionFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author noemy
 */
public class ProcedureDAOTest {

    @Before
    public void setUp() throws DatabaseUnitException, MalformedURLException, SQLException, ClassNotFoundException {
        File xml = new File(getClass().getResource("procedure_data.xml").getFile());
        IDataSet dataset = new FlatXmlDataSetBuilder().build(xml);
        DatabaseConnection database = new DatabaseConnection(getConnectionFactory());
        DatabaseOperation.CLEAN_INSERT.execute(database, dataset);
    }

    @Test
    public void getAll() throws SQLException, ClassNotFoundException {

    }

    @Test
    public void save() throws SQLException {

    }

}
