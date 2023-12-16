public class ApparelItem {
    private String itemCode;
    private String name;
    private String brand;
    private String size;
    private int quantity;
    private double price;

    public ApparelItem(String itemCode, String name, String brand, int quantity, double price, String size) {
        this.itemCode = itemCode;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    // Getters and Setters

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Additional Methods

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Size: " + size);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }

    public void updateQuantity(int deltaQuantity) {
        // Add validation logic if needed
        this.quantity += deltaQuantity;
    }

    public double calculateTotalPrice() {
        return quantity * price;
    }

    
}