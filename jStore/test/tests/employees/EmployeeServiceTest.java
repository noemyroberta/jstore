package tests.employees;

import br.com.ifal.daos.EmployeeDAO;
import br.com.ifal.models.Addresses;
import br.com.ifal.models.Employees;
import br.com.ifal.services.EmployeeService;
import br.com.ifal.services.ValidateCPF;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 *
 * @author noemy
 */
public class EmployeeServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void registerEmployeeTrue() {

        Employees employee = new Employees();
        Addresses address = new Addresses();

        employee.setBirthDate("21/03/1997");
        employee.setCellphone("(82)98113-6468");
        employee.setCpf("381.183.780-04");
        employee.setName("Noemy Roberta de Oliveira Silva");
        employee.setUsername("noemyroberta");
        employee.setPassword("51304996");
        employee.setFunction("Técnica em Informática");

        address.setCity("Arapiraca");
        address.setNeighborhood("Graciliano Ramos");
        address.setStreet("Rua Marechal Deodoro da Fonseca");
        address.setNumber(156);

        employee.setAddress(address);

        EmployeeDAO employeeDAO = Mockito.mock(EmployeeDAO.class);
        ValidateCPF validateCpf = Mockito.mock(ValidateCPF.class);

        Mockito.when(validateCpf.validateCPF(employee.getCpf())).thenReturn(Boolean.TRUE);

        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeDAO(employeeDAO);
        employeeService.setCpf(validateCpf);

        employeeService.registerEmployee(employee);
    }

    @Test
    public void registerEmployeeFalse() {

    }

    @Test
    public void registerEmployeeInvalidCPF() {
    }
    
    @Test
    public void registerEmployeeNull() {
        
    }
    
    @Test
    public void loginEmployeeInvalid() {
        
    }
    
    @Test
    public void loginEmployeeValid() {
        
    }
}
