package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public abstract class Persons {
    
    private String name;
    private String cpf;
    private String email;
    private String birthDate;
    private String cellphone;
    private Addresses address;
    
    public Persons() {
        
    }
    
    public Persons(String name, String cpf, 
                   String email, String birthDate, 
                   String cellphone) {
        
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.cellphone = cellphone;
        
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birth_date) {
        this.birthDate = birth_date;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Persons {" 
                + "name = " + name + ", "
                + "cpf = " + cpf + ", "
                + "email = " + email + ", "
                + "birth_date = " + birthDate + ", "
                + "cellphone = " + cellphone + '}';
    }
    
}
