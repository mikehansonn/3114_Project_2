import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    /**
     * Test the insert function
     */
    @Test
    public void testSeminarInsert() {
        BinarySearchTree<Integer, Seminar> seminarTree = new BinarySearchTree<>();
        Seminar sem1 = new Seminar();
        sem1.setID(1);
        Seminar sem2 = new Seminar();
        sem1.setID(2);
        Seminar sem3 = new Seminar();
        sem1.setID(10);
        Seminar sem4 = new Seminar();
        sem1.setID(3);
        seminarTree.insert(1, sem1);
        seminarTree.insert(2, sem2);
        seminarTree.insert(10, sem3);
        seminarTree.insert(3, sem4);
        seminarTree.delete(2);
        
        System.out.println(seminarTree.toString());
    }

    /**
     * Test the search of the seminar
     */
    @Test
    public void testSeminarSearch() {
        BinarySearchTree<Integer, Seminar> seminarTree = new BinarySearchTree<>();
        Seminar sem1 = new Seminar();
        sem1.setID(1);
        Seminar sem2 = new Seminar();
        sem1.setID(2);
        Seminar sem3 = new Seminar();
        sem1.setID(10);
        Seminar sem4 = new Seminar();
        sem1.setID(3);
        seminarTree.insert(1, sem1);
        seminarTree.insert(2, sem2);
        seminarTree.insert(10, sem3);
        seminarTree.insert(3, sem4);
        seminarTree.search(2, 2);
    }
}
