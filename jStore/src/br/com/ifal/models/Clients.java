package br.com.ifal.models;

public class Clients extends Persons {

    public Clients() {
        
    }

    public Clients(String name, String cpf, 
                   String email, String birthDate, String cellphone) {
        super(name, cpf, email, birthDate, cellphone);
    } 
    
}
