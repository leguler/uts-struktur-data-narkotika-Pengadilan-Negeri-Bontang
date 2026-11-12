package uts.narkotika.struktur;

public class ArrayStack<T> {
    private Object[] elements;
    private int top;
    private static final int DEFAULT_CAPACITY = 16;

    public ArrayStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public void push(T item) {
        if (top + 1 == elements.length) {
            resize(elements.length * 2);
        }
        elements[++top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong");
        }
        T item = (T) elements[top];
        elements[top--] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong");
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean searchPreserve(T target) {
        ArrayStack<T> temp = new ArrayStack<>();
        boolean found = false;
        while (!isEmpty()) {
            T current = pop();
            if (target == null ? current == null : target.equals(current)) {
                found = true;
            }
            temp.push(current);
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return found;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}
