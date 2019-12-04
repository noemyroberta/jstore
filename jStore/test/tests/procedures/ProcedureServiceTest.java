package tests.procedures;


import org.junit.Test;
import br.com.ifal.models.Procedures;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author noemy
 */
public class ProcedureServiceTest {
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void registerProcedureTrue(Procedures part) {
    }

    @Test
    public void registerProcedureInvalidPrice(Procedures procedure) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Price cannot be zero");
    }

    @Test
    public void registerProcedureNull(Procedures procedure) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Part data cannot be empty.");
    }

    @Test
    public void registerProcedureRequiredFieldsNull(Procedures procedure) {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("There are fields that cannot be empty.");
    }
}
