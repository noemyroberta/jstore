package br.com.ifal.models;

/**
 *
 * @author noemy
 */
public class Parts {

    private String description;
    private String serialNumber;
    private String manufacturer;
    private String generation;
    private Float price;
    private String stock;

    public Parts(String description, String serialNumber,
            String manufacturer, String generation, Float price, String stock) {
        this.description = description;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.generation = generation;
        this.price = price;
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
}
