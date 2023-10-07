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
        String check = "ID Tree:\n"
                + "This tree is empty\n"
                + "Search FAILED -- There is no record with ID 1\n"
                + "Seminars matching keyword VT:\n"
                + "Insert FAILED - Bad x, y coordinates: -1, 10\n"
                + "Insert FAILED - Bad x, y coordinates: 10, 128\n"
                + "Successfully inserted record with ID 1\n"
                + "ID: 1, Title: Overview of HCI Research at VT\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
                + "Description: This seminar will present an overview of HCI research at VT\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
                + "Successfully inserted record with ID 2\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
                + "Description: Introduction to   bioinformatics and computation biology\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
                + "Successfully inserted record with ID 10\n"
                + "ID: 10, Title: Computing Systems Research at VT\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
                + "Description: Seminar about the      Computing systems research at      VT\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\n"
                + "Successfully inserted record with ID 3\n"
                + "ID: 3, Title: Overview of HPC and CSE Research at VT\n"
                + "Date: 1203301125, Length: 35, X: 0, Y: 0, Cost: 25\n"
                + "Description: Learn what kind of    research is done on HPC  and CSE at VT\n"
                + "Keywords: HPC, CSE, computer_science\n"
                + "ID Tree:\n"
                + "      null\n"
                + "    10\n"
                + "        null\n"
                + "      3\n"
                + "        null\n"
                + "  2\n"
                + "    null\n"
                + "1\n"
                + "  null\n"
                + "Number of records: 4\n"
                + "Date Tree:\n"
                + "        null\n"
                + "      1203301125\n"
                + "        null\n"
                + "    0701250830\n"
                + "      null\n"
                + "  0610071600\n"
                + "    null\n"
                + "0610051600\n"
                + "  null\n"
                + "Number of records: 4\n"
                + "Keyword Tree:\n"
                + "            null\n"
                + "          science\n"
                + "            null\n"
                + "        high_performance_computing\n"
                + "            null\n"
                + "          grids\n"
                + "                null\n"
                + "              computer_science\n"
                + "                null\n"
                + "            computer\n"
                + "              null\n"
                + "      computation_biology\n"
                + "        null\n"
                + "    Virginia_Tech\n"
                + "        null\n"
                + "      Virginia_Tech\n"
                + "        null\n"
                + "  VT\n"
                + "      null\n"
                + "    VT\n"
                + "        null\n"
                + "      VT\n"
                + "          null\n"
                + "        HPC\n"
                + "          null\n"
                + "HCI\n"
                + "    null\n"
                + "  Computer_Science\n"
                + "          null\n"
                + "        Computer_Science\n"
                + "            null\n"
                + "          CSE\n"
                + "            null\n"
                + "      Biology\n"
                + "        null\n"
                + "    Bioinformatics\n"
                + "      null\n"
                + "Number of records: 18\n"
                + "Cost Tree:\n"
                + "  null\n"
                + "45\n"
                + "    null\n"
                + "  30\n"
                + "        null\n"
                + "      25\n"
                + "        null\n"
                + "    17\n"
                + "      null\n"
                + "Number of records: 4\n"
                + "Location Tree:\n"
                + "I\n"
                + "  I\n"
                + "    I\n"
                + "      I\n"
                + "        I\n"
                + "          I\n"
                + "            I\n"
                + "              Leaf with 1 objects: 3\n"
                + "              Leaf with 2 objects: 1 2\n"
                + "            E\n"
                + "          Leaf with 1 objects: 10\n"
                + "        E\n"
                + "      E\n"
                + "    E\n"
                + "  E\n"
                + "Insert FAILED - There is already a record with ID 10\n"
                + "Seminars matching keyword VT:\n"
                + "ID: 10, Title: Computing Systems Research at VT\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
                + "Description: Seminar about the      Computing systems research at      VT\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
                + "Description: Introduction to   bioinformatics and computation biology\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
                + "ID: 1, Title: Overview of HCI Research at VT\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
                + "Description: This seminar will present an overview of HCI research at VT\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
                + "Found record with ID 1:\n"
                + "ID: 1, Title: Overview of HCI Research at VT\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
                + "Description: This seminar will present an overview of HCI research at VT\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
                + "Seminars with costs in range 30 to 50:\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
                + "Description: Introduction to   bioinformatics and computation biology\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
                + "ID: 1, Title: Overview of HCI Research at VT\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
                + "Description: This seminar will present an overview of HCI research at VT\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
                + "7 nodes visited in this search\n"
                + "Seminars within 1 units of -1, 0:\n"
                + "Found a record with key value 3 at 0, 0\n"
                + "8 nodes visited in this search\n"
                + "Seminars within 2000 units of -1, 0:\n"
                + "Found a record with key value 3 at 0, 0\n"
                + "Found a record with key value 1 at 10, 10\n"
                + "Found a record with key value 2 at 10, 10\n"
                + "Found a record with key value 10 at 30, 10\n"
                + "15 nodes visited in this search\n"
                + "Seminars within 0 units of 10, 10:\n"
                + "Found a record with key value 1 at 10, 10\n"
                + "Found a record with key value 2 at 10, 10\n"
                + "8 nodes visited in this search\n"
                + "Seminars within 0 units of 11, 11:\n"
                + "8 nodes visited in this search\n"
                + "Seminars within 20 units of 10, 10:\n"
                + "Found a record with key value 3 at 0, 0\n"
                + "Found a record with key value 1 at 10, 10\n"
                + "Found a record with key value 2 at 10, 10\n"
                + "Found a record with key value 10 at 30, 10\n"
                + "11 nodes visited in this search\n"
                + "Seminars with dates in range 0 to 1:\n"
                + "ID: 1, Title: Overview of HCI Research at VT\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
                + "Description: This seminar will present an overview of HCI research at VT\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
                + "Description: Introduction to   bioinformatics and computation biology\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
                + "ID: 10, Title: Computing Systems Research at VT\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
                + "Description: Seminar about the      Computing systems research at      VT\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\n"
                + "8 nodes visited in this search\n"
                + "Record with ID 1 successfully deleted from the database\n"
                + "Delete FAILED -- There is no record with ID 1\n"
                + "ID Tree:\n"
                + "    null\n"
                + "  10\n"
                + "      null\n"
                + "    3\n"
                + "      null\n"
                + "2\n"
                + "  null\n"
                + "Number of records: 3\n"
                + "Location Tree:\n"
                + "I\n"
                + "  I\n"
                + "    I\n"
                + "      I\n"
                + "        I\n"
                + "          I\n"
                + "            I\n"
                + "              Leaf with 1 objects: 3\n"
                + "              Leaf with 2 objects: 1 2\n"
                + "            E\n"
                + "          Leaf with 1 objects: 10\n"
                + "        E\n"
                + "      E\n"
                + "    E\n"
                + "  E\n";
        assertEquals(check, out.toString());
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
        String check = "Seminars within 4 units of 2, 3:\n"
                + "1 nodes visited in this search\n"
                + "";
        
        assertEquals(check, out.toString());
    }
}

