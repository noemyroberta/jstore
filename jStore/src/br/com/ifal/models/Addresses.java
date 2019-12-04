package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public class Addresses {

    private String city;
    private String neighborhood;
    private String street;
    private int number;

    public Addresses() {
        
    }
    
    public Addresses(String city, String neighborhood, 
                     String street, int number) {
        
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Addresses {" 
                + "city = " + city + ", "
                + "neighborhood = " + neighborhood + ", "
                + "street = " + street + ", "
                + "number=" + number + '}';
    }
     
}
