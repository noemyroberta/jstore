package tests.clients;


import br.com.ifal.daos.ClientDAO;
import br.com.ifal.models.Addresses;
import br.com.ifal.models.Clients;
import br.com.ifal.services.ClientService;
import br.com.ifal.services.ValidateCPF;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 *
 * @author noemy
 */
public class ClientServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void registerClientTrue() {
        Clients client = new Clients();
        Addresses address = new Addresses();

        client.setCpf("830.959.370-83");
        client.setCellphone("(82)9999-5130");
        client.setBirthDate("04/12/2001");
        client.setName("Severina da Silva Santos");

        address.setCity("Arapiraca");
        address.setNeighborhood("São Gonçalo");
        address.setStreet("Rua Floriano Peixoto Guimarães");
        address.setNumber(12);

        client.setAddress(address);

        ClientDAO clientDAO = Mockito.mock(ClientDAO.class);
        ValidateCPF validateCpf = Mockito.mock(ValidateCPF.class);

        Mockito.when(validateCpf.validateCPF(client.getCpf())).thenReturn(Boolean.TRUE);

        ClientService clientService = new ClientService();
        clientService.setClientDAO(clientDAO);
        clientService.setCpf(validateCpf);

        clientService.registerClient(client);
    }
    
    @Test
    public void registerClientFalse() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("There are fields that cannot be empty.");
        
        Clients client = new Clients();
        Addresses address = new Addresses();

        client.setCpf("972.747.490-05");
        client.setCellphone("(82)9999-5130");
        client.setBirthDate("04/12/2001");
        client.setName("Severina da Silva Santos");

        address.setCity("");
        address.setNeighborhood("");
        address.setStreet("Rua Floriano Peixoto Guimarães");
        address.setNumber(12);

        client.setAddress(address);

        ClientDAO clientDAO = Mockito.mock(ClientDAO.class);
        ValidateCPF validateCpf = Mockito.mock(ValidateCPF.class);

        Mockito.when(validateCpf.validateCPF(client.getCpf())).thenReturn(Boolean.FALSE);

        ClientService clientService = new ClientService();
        clientService.setClientDAO(clientDAO);
        clientService.setCpf(validateCpf);

        clientService.registerClient(client);
    }

    @Test
    public void registerClientInvalidCPF() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Error, invalid CPF.");

        Clients client = new Clients();
        Addresses address = new Addresses();

        client.setCpf("111.111.111-11");
        client.setCellphone("(82)9999-5130");
        client.setBirthDate("04/12/2001");
        client.setName("Severina da Silva Santos");

        address.setCity("Arapiraca");
        address.setNeighborhood("São Gonçalo");
        address.setStreet("Rua Floriano Peixoto Guimarães");
        address.setNumber(12);

        client.setAddress(address);

        ClientDAO clientDAO = Mockito.mock(ClientDAO.class);
        ValidateCPF validateCpf = Mockito.mock(ValidateCPF.class);

        Mockito.when(validateCpf.validateCPF(client.getCpf())).thenReturn(Boolean.FALSE);

        ClientService clientService = new ClientService();
        clientService.setClientDAO(clientDAO);
        clientService.setCpf(validateCpf);

        clientService.registerClient(client);
    }
    
    @Test
    public void registerClientNull(Clients client) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Client data cannot be empty.");
    }

}
