
package tests.employees;

import br.com.ifal.daos.EmployeeDAO;
import br.com.ifal.models.Employees;
import org.junit.Test;

/**
 *
 * @author noemy
 */
public class EmployeeTest {
    
    /*
    * Teste utilizado para verificar se a data de nascimento colocada pelo usuário
    * corresponde à data de hoje ou à uma data futura
     */
    @Test
    public void birthDateAtual(String birthDate) {

    }

    /*
    * Teste utilizado para verificar se o campo de texto é longo demais
     */
    @Test
    public void bigFields(Employees client) {

    }

    /*
    * Teste utilizado para verificar se foram colocados caracteres em campos inadequados
    * Ex.: símbolos no campos de idade
    */
    @Test
    public void inappropriateCharacter(Employees client) {

    }
    
    /*
    * Verifica se as informações são as mesmas que as já cadastradas no banco
    */
    @Test
    public void duplicateInformations(Employees employee) {
        
    }
    
    /*
    * Verifica se o login existe
    */
    @Test
    public void validateLogin(Employees employee) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.verifyLogin(employee);
    }
}
