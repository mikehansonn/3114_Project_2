import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * @author mikehanson matt02
 * @version 9/25/23
 */
public class SemSearchTest extends TestCase {
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
     * Get code coverage of the class declaration.
     * @throws Exception file not found exception
     */
    public void testMInitx() throws Exception
    {
        SemSearch sem = new SemSearch(128);
        assertNotNull(sem);
        String[] args = { "128", "P2Sample_input.txt"};
        SemSearch.main(args);
        assertEquals("", out.toString());
    }
    
    /**
     * Test the insert function
     */
    @Test
    public void testInsertSeminar() {
        SemSearch search = new SemSearch(64);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, 
            keywords, "This is a great seminar");

        search.insertSeminar(sem1, 1);
        String expected = "Successfully inserted record with ID 1\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Insert FAILED - There is already a record with ID 1"
                + "\n";
        search.insertSeminar(sem1, 1);
        assertEquals(expected, out.toString());
    }
     
    /**
     * Test the delete seminar
     */
    @Test
    public void testDeleteSeminar() {
        SemSearch search = new SemSearch(64);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, 
            keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)-15, (short)-33, 125, 
                keywords, "This is a great seminar");

        search.insertSeminar(sem1, 1);
        search.insertSeminar(sem1, 0);
        search.insertSeminar(sem1, 2);
        search.insertSeminar(sem2, 5);
        search.deleteSeminar(10);
        search.deleteSeminar(1);
        String expected = "Successfully inserted record with ID 1\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Successfully inserted record with ID 0\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Successfully inserted record with ID 2\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Insert FAILED - Bad x, y coordinates: -15, -33\n"
                + "Delete FAILED -- There is no record with ID 10\n"
                + "Record with ID 1 successfully deleted from the database\n"
                + "";
        assertEquals(expected, out.toString());
    }

    /**
     * Test the print method
     */
    @Test
    public void testPrint() {
        SemSearch search = new SemSearch(64);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, 
            keywords, "This is a great seminar");

        search.insertSeminar(sem1, 1);
        search.insertSeminar(sem1, 0);
        search.insertSeminar(sem1, 2);
        search.printSeminar("date");
        search.printSeminar("keyword");
        search.printSeminar("cost");
        search.printSeminar("ID");
        search.printSeminar("location");
        String[] set = { "", "ID", "100"};
        String[] set2 = { "", "ID", "1"};
        search.searchSeminar(set);
        search.searchSeminar(set2);
        String expected = "Successfully inserted record with ID 1\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Successfully inserted record with ID 0\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Successfully inserted record with ID 2\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n"
                + "Date Tree:\n"
                + "  null\n"
                + "2405231000\n"
                + "    null\n"
                + "  2405231000\n"
                + "      null\n"
                + "    2405231000\n"
                + "      null\n"
                + "Number of records: 3\n"
                + "Keyword Tree:\n"
                + "    null\n"
                + "  two\n"
                + "        null\n"
                + "      two\n"
                + "          null\n"
                + "        two\n"
                + "          null\n"
                + "    three\n"
                + "        null\n"
                + "      three\n"
                + "          null\n"
                + "        three\n"
                + "          null\n"
                + "one\n"
                + "      null\n"
                + "    one\n"
                + "        null\n"
                + "      one\n"
                + "        null\n"
                + "  four\n"
                + "      null\n"
                + "    four\n"
                + "        null\n"
                + "      four\n"
                + "        null\n"
                + "Number of records: 12\n"
                + "Cost Tree:\n"
                + "  null\n"
                + "125\n"
                + "    null\n"
                + "  125\n"
                + "      null\n"
                + "    125\n"
                + "      null\n"
                + "Number of records: 3\n"
                + "ID Tree:\n"
                + "    null\n"
                + "  2\n"
                + "    null\n"
                + "1\n"
                + "    null\n"
                + "  0\n"
                + "    null\n"
                + "Number of records: 3\n"
                + "Location Tree:\n"
                + "Leaf with 3 objects: 1 1 1\n"
                + "Search FAILED -- There is no "
                + "record with ID 100\n"
                + "Found record with ID 1:\n"
                + "ID: 1, Title: Seminar Title\n"
                + "Date: 2405231000, Length: 75, "
                + "X: 15, Y: 33, Cost: 125\n"
                + "Description: This is a great seminar\n"
                + "Keywords: one, two, three, four\n";

        assertEquals(expected, out.toString());
    }
    
   /**
    * Few Final Inserts 
    */
    public void testFailInserts() {
        SemSearch search = new SemSearch(64);
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)4000, (short)33, 125, 
            keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)-33, 125, 
                keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)-20, (short)10, 125, 
                keywords, "This is a great seminar");
        Seminar sem4 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)50, (short)128, 125, 
                keywords, "This is a great seminar");
        
        search.insertSeminar(sem1, sem1.id());
        search.insertSeminar(sem2, sem2.id());
        search.insertSeminar(sem3, sem3.id());
        search.insertSeminar(sem4, sem4.id());
        String check = "Insert FAILED - Bad x, y coordinates: 4000, 33\n"
                + "Insert FAILED - Bad x, y coordinates: 10, -33\n"
                + "Insert FAILED - Bad x, y coordinates: -20, 10\n"
                + "Insert FAILED - Bad x, y coordinates: 50, 128\n"
                + "";
        
        assertEquals(check, out.toString());
    }
    
    /**
     * Test the search functions
     */
    public void testSearches() {
        SemSearch search = new SemSearch(64);
        String[] searches = { "search", "location", "2", "3", "4"};
        search.searchSeminar(searches);
        String check = "Seminars within 4 units of 2, 3:\n";
        
        assertEquals(check, out.toString());
    }
}

