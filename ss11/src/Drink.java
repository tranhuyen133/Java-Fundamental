public abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    // Constructor
    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Mã: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Giá gốc: " + price);
    }
}

