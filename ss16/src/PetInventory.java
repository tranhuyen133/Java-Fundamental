// PetInventory.java
import java.util.ArrayList;
import java.util.List;

public class PetInventory implements IRepository<Pet> {
    private final List<Pet> pets = new ArrayList<>();

    @Override
    public boolean add(Pet item) {
        if (findById(item.getId()) != null) return false;
        pets.add(item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        Pet p = findById(id);
        if (p == null) return false;
        return pets.remove(p);
    }

    @Override
    public Pet findById(String id) {
        for (Pet p : pets) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    @Override
    public List<Pet> findAll() {
        return pets;
    }
}