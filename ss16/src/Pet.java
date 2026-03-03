// Pet.java
public class Pet {
    private String id;
    private String name;
    private String species;
    private String breed;
    private int age;
    private double price;
    private String ownerId; // null if not sold

    public Pet(String id, String name, String species, String breed, int age, double price) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.price = price;
        this.ownerId = null;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public double getPrice() { return price; }
    public String getOwnerId() { return ownerId; }

    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", ownerId=" + (ownerId == null ? "N/A" : ownerId) +
                '}';
    }
}