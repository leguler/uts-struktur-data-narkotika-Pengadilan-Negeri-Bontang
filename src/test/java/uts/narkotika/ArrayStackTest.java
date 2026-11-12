package uts.narkotika;

import org.junit.jupiter.api.Test;
import uts.narkotika.struktur.ArrayStack;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
    void testPushPopLifo() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("IMPORT");
        stack.push("FILTER");
        stack.push("SORT");

        assertEquals(3, stack.size());
        assertEquals("SORT", stack.pop());
        assertEquals("FILTER", stack.pop());
        assertEquals("IMPORT", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSearchPreserveUrutan() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("AKSI-1");
        stack.push("AKSI-2");
        stack.push("AKSI-3");

        assertTrue(stack.searchPreserve("AKSI-2"));
        assertFalse(stack.searchPreserve("AKSI-99"));

        assertEquals("AKSI-3", stack.pop());
        assertEquals("AKSI-2", stack.pop());
        assertEquals("AKSI-1", stack.pop());
    }
}
