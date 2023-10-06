import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The internal node test class
 * 
 * @author mikehanson
 * @version 10/5/23
 */
public class InternalNodeTest {

    /**
     * Test the getLeft
     */
    @Test
    public void testGetLeft() {
        InternalNode node = new InternalNode(new EmptyNode(), new EmptyNode());
        assertTrue(node.getLeft() instanceof EmptyNode);
    }

    /**
     * Test the getRight
     */
    @Test
    public void testGetRight() {
        InternalNode node = new InternalNode(new EmptyNode(), new EmptyNode());
        assertTrue(node.getRight() instanceof EmptyNode);
    }
    /**
     * Test the insert
     */
    @Test
    public void testInsert() {
        InternalNode node = new InternalNode(new EmptyNode(), new EmptyNode());
        String[] keywords = { "one", "two", "three", "four"};
        Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
                (short)10, (short)10, 125, keywords, "This is a great seminar");
        
        node.insert(sem1, true, 0, 0, 32, 32);
        assertTrue(node.getLeft() instanceof LeafNode);
        node.insert(sem1, true, 0, 0, 16, 16);
        assertTrue(node.getRight() instanceof LeafNode);
        node.insert(sem1, false, 0, 0, 32, 32);
        assertTrue(node.getLeft() instanceof LeafNode);
        node.insert(sem1, false, 0, 0, 16, 16);
        assertTrue(node.getRight() instanceof LeafNode);
    }

}
