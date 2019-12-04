/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public class Suppliers {
    
    private String companyName;
    private String cnpj;
    private Sectors sector;

    public Suppliers() {
        
    }
    
    public Suppliers(String companyName, String cnpj, Sectors sector) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.sector = sector;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Sectors getSector() {
        return sector;
    }

    public void setSector(Sectors sector) {
        this.sector = sector;
    }
    
}
