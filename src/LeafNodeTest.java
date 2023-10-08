import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the leafNode class
 * 
 * @author mikehanson
 * @version 10/7/23 
 */
public class LeafNodeTest {
    /**
     * Test the leafnode insert
     */
    @Test
    public void testInsertCOnditions() {
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, 
            keywords, "This is a great seminar");
        Seminar sem2 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)15, (short)30, 125, 
                keywords, "This is a great seminar");
        Seminar sem3 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)33, 125, 
                keywords, "This is a great seminar");
        LinkedList<Seminar> list = new LinkedList<>();
        list.add(sem1, 1);
        BintreeInterface node = new LeafNode(list);
        node.insert(sem2, false, 0, 0, 128, 128);
        node.insert(sem3, false, 0, 0, 128, 128);
        
        assertEquals("1", node.toString());
    }

}
