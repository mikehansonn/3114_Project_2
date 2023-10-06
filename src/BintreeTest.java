import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Bintreemanager
 * 
 * @author mikehanson mattt02
 * @version 10/3/23
 */
public class BintreeTest { 
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
     * Test the general insert
     */
    @Test
    public void testInsert() {
        Bintree manager = new Bintree(0, 0, 128, 128);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem2 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(2, "Seminar Title", "2405231000", 75,
                (short)30, (short)30, 125, keywords, "This is a great seminar");
        Seminar sem4 = new Seminar(3, "Seminar Title", "2405231000", 75,
                (short)0, (short)0, 125, keywords, "This is a great seminar");
        Seminar sem5 = new Seminar(4, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        
        manager.insert(sem2);
        manager.insert(sem3);
        manager.insert(sem4);
        manager.insert(sem5);
        String check = "I\n"
                + "  I\n"
                + "    I\n"
                + "      I\n"
                + "        I\n"
                + "          I\n"
                + "            I\n"
                + "              Leaf with 1 objects: 3\n"
                + "              Leaf with 2 objects: 1 4\n"
                + "            E\n"
                + "          Leaf with 1 objects: 2\n"
                + "        E\n"
                + "      E\n"
                + "    E\n"
                + "  E\n"
                + "";
        System.out.print(manager.toString());
        assertEquals(check, out.toString());
    }

    /**
     * Test the stack insert
     */
    @Test
    public void testDoubleInsert() {
        Bintree manager = new Bintree(0, 0, 128, 128);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
                (short)30, (short)30, 125, keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");

        manager.insert(sem1);
        manager.insert(sem2);
        manager.insert(sem3);
        String check = "I\n"
                + "  I\n"
                + "    I\n"
                + "      I\n"
                + "        I\n"
                + "          Leaf with 2 objects: 1 2\n"
                + "          Leaf with 1 objects: 3\n"
                + "        E\n"
                + "      E\n"
                + "    E\n"
                + "  E\n";
        System.out.print(manager.toString());
        assertEquals(check, out.toString());
    }

    /**
     * Test the file case
     */
    @Test
    public void testTextFileCase() {
        Bintree manager = new Bintree(0, 0, 128, 128);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
                (short)30, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
                (short)0, (short)0, 125, keywords, "This is a great seminar");

        manager.insert(sem1);
        manager.insert(sem2);
        manager.insert(sem3);
        String check = "I\n"
                + "  I\n"
                + "    I\n"
                + "      I\n"
                + "        I\n"
                + "          I\n"
                + "            I\n"
                + "              Leaf with 1 objects: 3\n"
                + "              Leaf with 1 objects: 1\n"
                + "            E\n"
                + "          Leaf with 1 objects: 2\n"
                + "        E\n"
                + "      E\n"
                + "    E\n"
                + "  E\n";
        System.out.print(manager.toString());
        assertEquals(check, out.toString());
    }

    /**
     * Test the search function
     */
    @Test
    public void testSearch() {
        Bintree manager = new Bintree(0, 0, 128, 128);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
                (short)30, (short)10, 125, keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
                (short)0, (short)0, 125, keywords, "This is a great seminar");

        manager.insert(sem1);
        manager.insert(sem2);
        manager.insert(sem3);
        System.out.println(manager.toString());
        manager.searchWithinDistance(1, 1, 2000);
        assertEquals("", out.toString());
    }
}
