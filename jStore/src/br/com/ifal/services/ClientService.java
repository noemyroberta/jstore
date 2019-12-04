package br.com.ifal.services;

import br.com.ifal.models.Clients;
import br.com.ifal.daos.ClientDAO;

/**
 *
 * @author noemy
 */
public class ClientService {

    private ValidateCPF cpf;
    private ClientDAO clientDAO;

    public ClientService() {
        cpf = new ValidateCPF();
    }

    public void registerClient(Clients client) {
        if(client == null) {
            throw new RuntimeException("Client data cannot be empty.");
        }
        
        if(client.getBirthDate().equals("")
                || client.getCpf().equals("")
                || client.getCellphone().equals("")
                || client.getAddress().getCity().equals("")
                || client.getAddress().getNeighborhood().equals("")
                || client.getAddress().getStreet().equals("") 
                || client.getName().equals("")
                || client.getAddress().getNumber() == 0) {
            throw new RuntimeException("There are fields that cannot be empty.");
        }
        
        if(cpf.validateCPF(client.getCpf()) == false) {
            throw new RuntimeException("Error, invalid CPF.");
        }

        clientDAO.save(client);
    }

    public ValidateCPF getCpf() {
        return cpf;
    }

    public void setCpf(ValidateCPF cpf) {
        this.cpf = cpf;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

}
