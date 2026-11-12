package uts.narkotika;

import org.junit.jupiter.api.Test;
import uts.narkotika.struktur.SinglyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    void testAddAndSize() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        
        list.add("A");
        list.add("B");
        list.addLast("C");
        
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        
        list.validateInvariant();
    }

    @Test
    void testAddFirstAndInsert() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("B");
        list.addFirst("A");
        list.addLast("D");
        list.insert(2, "C"); // A, B, C, D
        
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));
        
        list.validateInvariant();
    }

    @Test
    void testRemoveFirstMiddleLast() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40); // 10, 20, 30, 40

        // Hapus tengah (index 1 -> nilai 20)
        assertEquals(20, list.remove(1));
        assertEquals(3, list.size());
        assertEquals(30, list.get(1));

        // Hapus pertama (index 0 -> nilai 10)
        assertEquals(10, list.remove(0));
        assertEquals(2, list.size());
        assertEquals(30, list.get(0));

        // Hapus terakhir (index terakhir -> nilai 40)
        assertEquals(40, list.remove(1));
        assertEquals(1, list.size());
        assertEquals(30, list.get(0));

        list.validateInvariant();
    }
}
