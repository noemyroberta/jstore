package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public class Employees extends Persons {
    
    private String username;
    private String password;
    private String function;

    public Employees() {

    }

    public Employees(String username, String password, String function, 
                     String name, String cpf, String email, 
                     String birthDate, String cellphone) {
        super(name, cpf, email, birthDate, cellphone);
        this.username = username;
        this.password = password;
        this.function = function;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Employees {" 
                + "username = " + username + ", "
                + "password = " + password + ", "
                + "function = " + function + '}';
    }
      
}
