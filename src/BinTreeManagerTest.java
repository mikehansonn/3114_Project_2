import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Bintreemanager
 * 
 * @author mikehanson mattt02
 * @version 10/3/23
 */
public class BinTreeManagerTest {

    @Test
    public void testInsert() {
        BinTreeManager manager = new BinTreeManager(0, 0, 128, 128);
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
        System.out.println(manager.toString());
    }

}
