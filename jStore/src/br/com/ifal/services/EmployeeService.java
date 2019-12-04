package br.com.ifal.services;

import br.com.ifal.daos.EmployeeDAO;
import br.com.ifal.models.Employees;

/**
 *
 * @author noemy
 */
public class EmployeeService {

    private ValidateCPF cpf;
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        cpf = new ValidateCPF();
    }

    public void registerEmployee(Employees employee) {

        if(employee == null) {
            throw new RuntimeException("Employee data cannot be empty.");
        }
        
        if(employee.getBirthDate().equals("")
                || employee.getCpf().equals("")
                || employee.getCellphone().equals("")
                || employee.getAddress().getCity().equals("")
                || employee.getAddress().getNeighborhood().equals("")
                || employee.getAddress().getStreet().equals("") 
                || employee.getName().equals("")
                || employee.getUsername().equals("")
                || employee.getPassword().equals("")
                || employee.getFunction().equals("")
                || employee.getAddress().getNumber() == 0) {
            throw new RuntimeException("There are fields that cannot be empty.");
        }
        
        if(cpf.validateCPF(employee.getCpf()) == false) {
            throw new RuntimeException("Error, invalid CPF.");
        }
        
        employeeDAO.save(employee);
    }

    public ValidateCPF getCpf() {
        return cpf;
    }

    public void setCpf(ValidateCPF cpf) {
        this.cpf = cpf;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    } 
}
