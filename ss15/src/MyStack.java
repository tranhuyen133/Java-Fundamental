import java.util.Arrays;

public class MyStack<T> {
    private Object[] stackArray;
    private int top;
    private int capacity;

    public MyStack(int size) {
        this.capacity = size;
        this.top = -1;
        stackArray = new Object[capacity];
    }

    public boolean push(T element) {
        if (top == capacity - 1) {
            System.err.println("Stack đầy");
            return false;
        }
        stackArray[++top] = element;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            System.err.println("Stack rỗng");
            return null;
        }
        return (T) stackArray[top--];
    }

    public T peek() {
        if (isEmpty()) {
            System.err.println("Stack rỗng");
            return null;
        }
        return (T) stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i <= top; i++) {
            if (i == top) {
                str.append(stackArray[i]);
            } else {
                str.append(stackArray[i]).append(", ");
            }
        }
        str.append(" ]");
        return str.toString();
    }
}