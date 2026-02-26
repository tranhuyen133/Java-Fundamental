import java.util.ArrayList;

public class MyArrayList<T> {

    private Object[] numbers;
    private int current = 0;

    public MyArrayList() {
        numbers = new Object[10];
    }

    public T[] getNumbers() {
        return (T[]) numbers;
    }

    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }

    public boolean add(T element) {
        numbers[current++] = element;
        return true;
    }

    public int size() {
        return current;
    }

    public T get(int index) {
        return (T) numbers[index];
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i = 0; i < size(); i++) {

            if(i != size() - 1) {
                result += numbers[i] + ", ";
            } else {
                result += numbers[i];
            }
        }
        result += " ]";
        return result;
    }
}