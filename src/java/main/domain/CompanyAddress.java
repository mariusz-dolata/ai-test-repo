package domain;

public class CompanyAddress {
    private long id;
    private String city;
    private String zip;
    private String street;
    private String addressNumber;
    
    public CompanyAddress() {}
    
    public CompanyAddress(long id, String city, String zip, String street, String addressNumber) {
        this.id = id;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.addressNumber = addressNumber;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getAddressNumber() {
        return addressNumber;
    }
    
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}