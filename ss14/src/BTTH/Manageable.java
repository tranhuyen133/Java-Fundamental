package BTTH;

public interface Manageable<T> {
    void add(T t);
    void update(String id);
    void delete(String id);
    void displayAll();
}