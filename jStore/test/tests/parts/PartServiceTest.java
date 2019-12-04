
package tests.parts;

import br.com.ifal.models.Parts;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author noemy
 */
public class PartServiceTest {
    
  @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void registerProcedureTrue(Parts part) {
    }

    @Test
    public void registerProcedureInvalidPrice(Parts part) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Price cannot be zero");
    }

    @Test
    public void registerProcedureNull(Parts part) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Part data cannot be empty.");
    }

    @Test
    public void registerProcedureRequiredFieldsNull(Parts part) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("There are fields that cannot be empty.");
    }
}
