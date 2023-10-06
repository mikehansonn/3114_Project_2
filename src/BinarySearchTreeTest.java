import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BST tests
 * 
 * @author mikehanson matt02
 * @version 9/25/23
 */
public class BinarySearchTreeTest {
    private final ByteArrayOutputStream out = 
            new ByteArrayOutputStream();
    private final PrintStream originalOut = 
            System.out;

    /**
     * Sets up grabbing the sysouts
     */
    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    /**
     * restore command window
     */
    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }

    /**
     * Test the insert function
     */
    @Test
    public void testSeminarInsert() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        BinarySearchTree<Integer, Seminar> emptyTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(10, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem4 = new Seminar(3, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(1, sem1);
        seminarTree.insert(10, sem3);
        seminarTree.insert(3, sem4);
        
        String structure = "    null\n" + //
                "  10\n" + //
                "      null\n" + //
                "    3\n" + //
                "      null\n" + //
                "1\n" + //
                "  null\n" + //
                "Number of records: 3" +
                "\nThis tree is empty\n";
        System.out.print(seminarTree.toString());
        System.out.print(emptyTree.toString());
        assertEquals(structure, out.toString());
        assertTrue(structure.equals(out.toString()));
    }

    /**
     * Test the search of the seminar
     */
    @Test
    public void testSeminarSearch() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(10, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem4 = new Seminar(3, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(1, sem1);
        seminarTree.insert(2, sem2);
        seminarTree.insert(10, sem3);
        seminarTree.insert(3, sem4);

        assertTrue(seminarTree.contains(1));
        assertTrue(seminarTree.contains(1));
        assertFalse(seminarTree.contains(12));
        assertFalse(seminarTree.contains(4));
    }
    
    /**
     * Test BST delete
     */
    @Test
    public void testDelete() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(10, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar sem4 = new Seminar(3, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(1, sem1);
        seminarTree.insert(10, sem3);
        seminarTree.insert(3, sem4);
        
        String structureBefore = "    null\n" + //
                "  10\n" + //
                "      null\n" + //
                "    3\n" + //
                "      null\n" + //
                "1\n" + //
                "  null\n" + //
                "Number of records: 3" +
                "\n";
        String structureAfter = "    null\n" + //
                "  10\n" + //
                "      null\n" + //
                "    3\n" + //
                "      null\n" + //
                "1\n" + //
                "  null\n" + //
                "Number of records: 3" +
                "\n    null\n"
                + "  3\n"
                + "    null\n"
                + "1\n"
                + "  null\n"
                + "Number of records: 2\n";
        System.out.print(seminarTree.toString());
        assertTrue(structureBefore.equals(out.toString()));
        seminarTree.delete(10, 10);
        System.out.print(seminarTree.toString());
        assertEquals(structureAfter, out.toString());
        seminarTree.delete(0, 0);
        seminarTree.delete(5, 5);
        seminarTree.delete(50, 50);
        assertEquals(structureAfter, out.toString());
    }

    /**
     * Test some extra delete things
     */
    @Test
    public void testMoreDelete() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(5, sem1);
        seminarTree.insert(2, sem1);
        seminarTree.insert(8, sem1);
        seminarTree.insert(1, sem1);
        seminarTree.insert(7, sem1);
        seminarTree.insert(10, sem1);
        seminarTree.insert(3, sem1);    
        String expected = "      null\n" + //
                "    10\n" + //
                "      null\n" + //
                "  8\n" + //
                "      null\n" + //
                "    7\n" + //
                "      null\n" + //
                "5\n" + //
                "    null\n" + //
                "  3\n" + //
                "    null\n" + //
                "Number of records: 5" + //
                "\n";
        seminarTree.delete(2, 1);
        seminarTree.delete(1, 1);
        seminarTree.delete(5, 5);
        System.out.print(seminarTree.toString());
        assertEquals(expected, out.toString());
    }
    
    /**
     * Test the contains final condition
     */
    @Test
    public void testContains() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(5, sem1);
        seminarTree.insert(2, sem1);
        seminarTree.insert(8, sem1);
        seminarTree.insert(1, sem1);
        seminarTree.insert(7, sem1);
        seminarTree.insert(10, sem1);
        seminarTree.insert(3, sem1); 
        
        assertTrue(seminarTree.contains(10));
        assertTrue(seminarTree.contains(3));
    }
    
    /**
     * Test the final delete case
     */
    @Test
    public void testDeleteMaxCase() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        seminarTree.insert(5, sem1);
        seminarTree.insert(2, sem1);
        seminarTree.insert(8, sem1);
        seminarTree.insert(1, sem1);
        seminarTree.insert(7, sem1);
        seminarTree.insert(10, sem1);
        seminarTree.insert(3, sem1); 

        seminarTree.delete(5, 1);
        String expected = "      null\n"
                + "    10\n"
                + "      null\n"
                + "  8\n"
                + "      null\n"
                + "    7\n"
                + "      null\n"
                + "3\n"
                + "    null\n"
                + "  2\n"
                + "      null\n"
                + "    1\n"
                + "      null\n"
                + "Number of records: 6\n";
        System.out.print(seminarTree.toString());
        assertEquals(expected, out.toString());
    }
    
    /**
     * Final delete test
     */
    @Test
    public void testFinalDelete() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one" };
        Seminar sem1 = new Seminar(1, "s", "12", 75,
            (short)15, (short)33, 125, keywords, "sem");
        seminarTree.insert(1, sem1);
        seminarTree.insert(2, sem1);
        seminarTree.insert(10, sem1);
        seminarTree.insert(3, sem1);
        
        seminarTree.delete(1, 1);
        String expected = "    null\n"
                + "  10\n"
                + "      null\n"
                + "    3\n"
                + "      null\n"
                + "2\n"
                + "  null\n"
                + "Number of records: 3\n";
        System.out.print(seminarTree.toString());
        assertEquals(expected, out.toString());
    }
    
    /**
     * Test the search function
     */
    @Test
    public void testSearch() {
        BinarySearchTree<Integer, Seminar> seminarTree = 
                new BinarySearchTree<>();
        String[] keywords = { "one" };
        Seminar sem1 = new Seminar(1, "s", "12", 75,
            (short)15, (short)33, 125, keywords, "sem");
        seminarTree.insert(5, sem1);
        seminarTree.insert(2, sem1);
        seminarTree.insert(8, sem1);
        seminarTree.insert(1, sem1);
        seminarTree.insert(7, sem1);
        seminarTree.insert(10, sem1);
        seminarTree.insert(3, sem1); 
        
        String expected1 = "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "8 nodes visited in this search\n";
        String expected2 = "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "8 nodes visited in this search\n"
                + "4 nodes visited in this search\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "ID: 1, Title: s\n"
                + "Date: 12, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: sem\n"
                + "Keywords: one\n"
                + "8 nodes visited in this search\n";
        seminarTree.search(20, 20);
        assertEquals("", out.toString());
        seminarTree.search(5, 8);
        assertEquals(expected1, out.toString());
        seminarTree.search(11, 15);
        assertEquals(
                expected1 + "4 nodes visited in this search\n", out.toString());
        seminarTree.search(0, 4);
        assertEquals(expected2, out.toString());
        seminarTree.search(0, 0);
        assertEquals(expected2, out.toString());
    }
}
