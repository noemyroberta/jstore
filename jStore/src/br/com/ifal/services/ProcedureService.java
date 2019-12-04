package br.com.ifal.services;

import br.com.ifal.daos.ProcedureDAO;
import br.com.ifal.models.Procedures;

/**
 *
 * @author noemy
 */
public class ProcedureService {

    private ValidatePrice validatePrice;
    private ProcedureDAO procedureDAO;
    
    public void registerProcedure(Procedures procedure) {
        if (procedure == null) {
            throw new RuntimeException("Procedure data cannot be empty.");
        }

        if (procedure.getDescription().equals("")
                || procedure.getEquipment().equals("")
                || procedure.getPrice() == null) {
            throw new RuntimeException("There are fields that cannot be empty.");
        }
        
        if (validatePrice.validatePrice(procedure.getPrice()) == false) {
            throw new RuntimeException("Price cannot be zero");
        }
        
        procedureDAO.save(procedure);
    }

    public ValidatePrice getValidatePrice() {
        return validatePrice;
    }

    public void setValidatePrice(ValidatePrice validatePrice) {
        this.validatePrice = validatePrice;
    }

    public ProcedureDAO getProcedureDAO() {
        return procedureDAO;
    }

    public void setProcedureDAO(ProcedureDAO procedureDAO) {
        this.procedureDAO = procedureDAO;
    }
    
}
