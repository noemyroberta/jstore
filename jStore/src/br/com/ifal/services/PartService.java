/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifal.services;

import br.com.ifal.daos.PartsDAO;
import br.com.ifal.models.Parts;

/**
 *
 * @author noemy
 */
public class PartService {

    private ValidatePrice validatePrice;
    private PartsDAO partDAO;

    public void registerPart(Parts part) {
        if (part == null) {
            throw new RuntimeException("Part data cannot be empty.");
        }

        if (part.getSerialNumber().equals("")
                || part.getGeneration().equals("")
                || part.getManufacturer().equals("")
                || part.getStock().equals("")
                || part.getPrice() == null) {
            throw new RuntimeException("There are fields that cannot be empty.");
        }

        if (validatePrice.validatePrice(part.getPrice()) == false) {
            throw new RuntimeException("Price cannot be zero");
        }

        partDAO.save(part);
    }

    public ValidatePrice getValidatePrice() {
        return validatePrice;
    }

    public void setValidatePrice(ValidatePrice validatePrice) {
        this.validatePrice = validatePrice;
    }

    public PartsDAO getPartDAO() {
        return partDAO;
    }

    public void setPartDAO(PartsDAO partDAO) {
        this.partDAO = partDAO;
    }

}
