import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Database db = new Database();

        System.out.println("OPGAVE A");
        db.getCoffeeNames();
        System.out.println("\nOPGAVE B");
        db.getCoffeesAboveNine();
        System.out.println("\nOPGAVE C");
        db.createSuppliers();
        for (Supplier supplier : db.getSuppliers()) {
            System.out.println(supplier.getStreet() + ", " + supplier.getZip() + ", " +
                    supplier.getCity() + ", " + supplier.getState());
        }

    }
}
