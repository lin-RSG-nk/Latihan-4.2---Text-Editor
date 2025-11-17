public class Stack<T> {

    private Object[] data = new Object[10];
    private int top = -1;

    public void push(T value) {
        if (top == data.length - 1) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[++top] = value;
    }

    public T pop() {
        if (isEmpty()) return null;
        return (T) data[top--];
    }

    public T peek() {
        if (isEmpty()) return null;
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
