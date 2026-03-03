// CustomerRegistry.java
import java.util.*;

public class CustomerRegistry {
    private final Map<String, Customer> customersById = new HashMap<>();
    private final Set<String> phones = new HashSet<>();

    public boolean register(Customer c) {
        if (customersById.containsKey(c.getId())) return false;
        if (phones.contains(c.getPhone())) return false;

        customersById.put(c.getId(), c);
        phones.add(c.getPhone());
        return true;
    }

    public Customer findById(String id) {
        return customersById.get(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customersById.values());
    }
}