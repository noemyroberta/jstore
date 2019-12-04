package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public class Procedures {
    
    private String description;
    private Float price;
    private String equipment;

    public Procedures(String description, Float price, String equipment) {
        this.description = description;
        this.price = price;
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Procedures {" + 
                    "description = " + description + 
                    ", price = " + price + 
                    ", equipment = " + equipment + 
                '}';
    }
     
}
