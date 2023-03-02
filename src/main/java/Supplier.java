public class Supplier {

    private String street;
    private int zip;
    private String city;
    private String state;

    public Supplier(String street,int zip,String city,String state) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
