import java.util.ArrayList;
import java.util.Scanner;

class Product {
    // Properties
    private String pname;
    private int qty;
    private double price;
    private double totalPrice;

    // Constructor
    Product(String pname, int qty, double price, double totalPrice) {
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    // Display Format
    public static void displayFormat() {
        System.out.print("\nName         Quantity   Price   Total Price\n");
    }
    // Display
    public void display() {
        System.out.format("%-9s %8d  %10.2f %10.2f\n", pname, qty, price, totalPrice);
    }
}

public class Billing_Machine {
    public static void main(String[] args) {
        
        // Variables
        String productName = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        char choice = '\0';
        
        // Create Scanner Class Object
        Scanner scan = new Scanner(System.in);

        ArrayList <Product> product = new ArrayList<Product>();

        do {
            // Read Input Values
            System.out.println("Enter Product Details:-");
            System.out.print("Name: ");
            productName = scan.nextLine();
            System.out.print("Quantity: ");
            quantity = scan.nextInt();
            System.out.print("Price (Per Item): ");
            price = scan.nextDouble();

            // Calculate Total Price for that Product
            totalPrice = price * quantity;

            // Calculate Overall Price
            overAllPrice += totalPrice;

            // Create Product Class Object & Add it to the List
            product.add( new Product(productName, quantity, price, totalPrice));

            // Ask for Continue...?
            System.out.print("Want to Add More Items...? (Yes or No): ");
            choice = scan.next().charAt(0);

            // Read Remaining Characters, Don't Store (no use)
            scan.nextLine();
        }
        while (choice == 'Y' || choice == 'y');

        // Display all Product with its Properties
        Product.displayFormat();
        for (Product p : product) {
            p.display();
        }

        // Overall Price
        System.out.println("\nOver All Price = " + overAllPrice);

        // Close Scanner
        scan.close();
    }
}
