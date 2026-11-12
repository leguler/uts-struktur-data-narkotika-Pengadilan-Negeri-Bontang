package uts.narkotika.struktur;

public class SinglyLinkedList<T> implements StrukturData<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void validateInvariant() {
        if (size == 0) {
            if (head != null || tail != null) {
                throw new IllegalStateException("Invariant violated: size 0 tetapi head/tail tidak null");
            }
        } else {
            if (head == null || tail == null) {
                throw new IllegalStateException("Invariant violated: size > 0 tetapi head/tail null");
            }
            Node<T> current = head;
            int countedSize = 0;
            while (current != null) {
                countedSize++;
                if (current.next == null) {
                    if (current != tail) {
                        throw new IllegalStateException("Invariant violated: node terakhir bukan tail");
                    }
                }
                current = current.next;
            }
            if (countedSize != size) {
                throw new IllegalStateException("Invariant violated: size field tidak sesuai dengan hitungan node (" + size + " vs " + countedSize + ")");
            }
        }
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        validateInvariant();
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        validateInvariant();
    }

    public void insert(int position, T value) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Posisi invalid: " + position);
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
        validateInvariant();
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posisi invalid: " + position);
        }
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posisi invalid: " + position);
        }
        T removedData;
        if (position == 0) {
            removedData = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
        size--;
        validateInvariant();
        return removedData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (value == null ? current.data == null : value.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        validateInvariant();
    }
}
