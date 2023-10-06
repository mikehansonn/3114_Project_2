import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the linked list
 * 
 * @author mikehanson matt02
 * @version 10/5/23
 */
public class LinkedListTest {

    /**
     * Test the isEmpty
     */
    @Test
    public void testIsEmpty() {
        LinkedList<Seminar> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.add(null, 1);
        assertFalse(list.isEmpty());
    }

    /**
     * Test the add funciton
     */
    @Test
    public void testAdd() {
        LinkedList<Seminar> list = new LinkedList<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        list.add(sem1, 1);
        list.add(sem1, 2);
        list.add(sem1, 3);
        Seminar[] array = list.toSemArray();

        assertEquals(array[0].id(), 1);
        assertEquals(array[1].id(), 1);
        assertEquals(array[2].id(), 1);
        String toS = list.toLinkedString();
        assertEquals("1 2 3", toS);
    }

    /**
     * Test the getData
     */
    @Test
    public void testGetData() {
        LinkedList<Seminar> list = new LinkedList<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        list.add(sem1, 1);

        assertEquals(1, list.getData().id());
        assertEquals(125, list.getData().cost());
        assertEquals(1, list.size());
    }

    /**
     * Test the remove call
     */
    @Test
    public void testRemove() {
        LinkedList<Seminar> list = new LinkedList<>();
        list.remove(null, 0);
        assertEquals(0, list.size());
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        list.add(sem1, 1);
        list.add(sem1, 2);
        list.add(sem1, 3);
        list.add(sem1, 4);
        list.add(sem1, 5);
        list.remove(sem1, 1);
        assertEquals(4, list.size());
        list.remove(sem1, 3);
        assertEquals(3, list.size());
        list.remove(sem1, 5);
        assertEquals(2, list.size());
        list.remove(sem1, 100);
        assertEquals(2, list.size());
    }
}
