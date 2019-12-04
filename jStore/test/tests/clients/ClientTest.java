
package tests.clients;

import br.com.ifal.models.Clients;
import org.junit.Test;

/**
 *
 * @author noemy
 */
public class ClientTest {

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
    public void bigFields(Clients client) {

    }

    /*
    * Teste utilizado para verificar se foram colocados caracteres em campos inadequados
    * Ex.: símbolos no campos de idade
    */
    @Test
    public void inappropriateCharacter(Clients client) {

    }
    
    /*
    * Verifica se as informações são as mesmas que as já cadastradas no banco
    */
    @Test
    public void duplicateInformations(Clients client) {
        
    }
}
