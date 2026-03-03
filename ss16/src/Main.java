import java.util.List;
import java.util.Scanner;

public class Main {
    private final PetInventory inventory = new PetInventory();
    private final CustomerRegistry registry = new CustomerRegistry();
    private final SpaService spa = new SpaService();
    private final ActivityLogger logger = new ActivityLogger();

    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().menuLoop();
    }

    private void menuLoop() {
        while (true) {
            System.out.println("\n========== PET KINGDOM ==========");
            System.out.println("1. Pet Inventory (List)");
            System.out.println("2. Loyal Customers (Map/Set)");
            System.out.println("3. Spa Service (Queue)");
            System.out.println("4. Activity Log (Stack)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    petMenu();
                    break;
                case "2":
                    customerMenu();
                    break;
                case "3":
                    spaMenu();
                    break;
                case "4":
                    logMenu();
                    break;
                case "0":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ===== PET MENU =====
    private void petMenu() {
        while (true) {
            System.out.println("\n--- PET INVENTORY ---");
            System.out.println("1. Add new pet");
            System.out.println("2. Show all pets");
            System.out.println("3. Find pet by ID");
            System.out.println("4. Remove pet by ID (sold)");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1":
                    addPet();
                    break;
                case "2":
                    showPets();
                    break;
                case "3":
                    findPet();
                    break;
                case "4":
                    removePet();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addPet() {
        String id = readNonEmpty("Pet ID: ");
        String name = readNonEmpty("Name: ");
        String species = readNonEmpty("Species: ");
        String breed = readNonEmpty("Breed: ");
        int age = readInt("Age: ");
        double price = readDouble("Price: ");

        Pet p = new Pet(id, name, species, breed, age, price);
        boolean ok = inventory.add(p);
        if (ok) {
            System.out.println("Added pet successfully.");
            logger.log("Added pet: " + id + " (" + name + ")");
        } else {
            System.out.println("Failed! Pet ID already exists.");
        }
    }

    private void showPets() {
        List<Pet> pets = inventory.findAll();
        if (pets.isEmpty()) {
            System.out.println("No pets in inventory.");
            return;
        }
        System.out.println("=== Pet List ===");
        for (Pet p : pets) System.out.println(p);
    }

    private void findPet() {
        String id = readNonEmpty("Enter pet ID: ");
        Pet p = inventory.findById(id);
        if (p == null) {
            System.out.println("Pet not found!");
        } else {
            System.out.println("Found: " + p);
        }
    }

    private void removePet() {
        String id = readNonEmpty("Enter pet ID to remove (sold): ");
        boolean ok = inventory.removeById(id);
        if (ok) {
            System.out.println("Removed pet successfully.");
            logger.log("Removed pet: " + id);
        } else {
            System.out.println("Failed! Pet not found.");
        }
    }

    // ===== CUSTOMER MENU =====
    private void customerMenu() {
        while (true) {
            System.out.println("\n--- LOYAL CUSTOMERS ---");
            System.out.println("1. Register member");
            System.out.println("2. Find customer by ID");
            System.out.println("3. Show all customers");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    findCustomer();
                    break;
                case "3":
                    showCustomers();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void registerCustomer() {
        String id = readNonEmpty("Customer ID: ");
        String name = readNonEmpty("Full name: ");
        String phone = readNonEmpty("Phone: ");
        String level = readMemberLevel("Member level (SILVER/GOLD/PLATINUM): ");
        int points = readInt("Points: ");

        Customer c = new Customer(id, name, phone, level, points);
        boolean ok = registry.register(c);
        if (ok) {
            System.out.println("Registered successfully.");
            logger.log("Registered customer: " + id + " (" + name + ")");
        } else {
            System.out.println("Failed! Duplicate customer ID or phone.");
        }
    }

    private void findCustomer() {
        String id = readNonEmpty("Enter customer ID: ");
        Customer c = registry.findById(id);
        if (c == null) System.out.println("Customer not found!");
        else System.out.println("Found: " + c);
    }

    private void showCustomers() {
        List<Customer> list = registry.findAll();
        if (list.isEmpty()) {
            System.out.println("No customers.");
            return;
        }
        System.out.println("=== Customer List ===");
        for (Customer c : list) System.out.println(c);
    }

    // ===== SPA MENU =====
    private void spaMenu() {
        while (true) {
            System.out.println("\n--- SPA SERVICE ---");
            System.out.println("1. Check-in pet to spa (enqueue)");
            System.out.println("2. Serve next (dequeue)");
            System.out.println("3. View waiting queue");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1":
                    spaCheckIn();
                    break;
                case "2":
                    spaServeNext();
                    break;
                case "3":
                    spa.viewQueue();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void spaCheckIn() {
        String ticketId = readNonEmpty("Ticket ID: ");
        String petId = readNonEmpty("Pet ID: ");

        Pet p = inventory.findById(petId);
        if (p == null) {
            System.out.println("Cannot check-in: Pet not found in inventory!");
            return;
        }

        String customerId = readNonEmpty("Customer ID: ");
        Customer customer = registry.findById(customerId);
        if (customer == null) {
            System.out.println("Cannot check-in: Customer not found!");
            return;
        }

        String service = readNonEmpty("Service type (bath/grooming/...): ");
        SpaTicket ticket = new SpaTicket(ticketId, petId, customerId, service);

        spa.checkIn(ticket);
        System.out.println("Checked in successfully.");
        logger.log("Spa check-in: ticket=" + ticketId + ", pet=" + petId + ", customer=" + customerId);
    }

    private void spaServeNext() {
        SpaTicket t = spa.serveNext();
        if (t == null) {
            System.out.println("No pets in spa queue.");
            return;
        }
        System.out.println("Now serving (FIFO): " + t);
        logger.log("Spa served: ticket=" + t.getTicketId());
    }

    // ===== LOG MENU =====
    private void logMenu() {
        while (true) {
            System.out.println("\n--- ACTIVITY LOG (STACK) ---");
            System.out.println("1. View recent actions");
            System.out.println("2. Undo (pop latest action)");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1":
                    logger.viewRecent();
                    break;
                case "2":
                    String undone = logger.undo();
                    if (undone == null) System.out.println("Nothing to undo.");
                    else System.out.println("Undo action: " + undone);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ===== HELPERS =====
    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty. Try again!");
        }
    }

    private String readMemberLevel(String prompt) {
        while (true) {
            String level = readNonEmpty(prompt).toUpperCase();
            if (level.equals("SILVER") || level.equals("GOLD") || level.equals("PLATINUM")) return level;
            System.out.println("Invalid level. Only SILVER/GOLD/PLATINUM!");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again!");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again!");
            }
        }
    }
}