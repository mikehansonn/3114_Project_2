/**
 * Interface for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public interface Bintree {
<<<<<<< HEAD
    // Insert a SeminarRecord into the tree
    Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height); 
    
    // Search for SeminarRecords within a certain distance of given x, y coordinates
=======
    /**
     * Insert a node into tree
     * 
     * @param record sem to store
     * @param vertical value
     */
    void insert(Seminar record, boolean vertical);
    
    /**
     * Search within a distance
     * 
     * @param x x value search
     * @param y y value search
     * @param distance total distance
     */
>>>>>>> d492c6b88b1bdbac1f8a4ca0baa8208e44853c27
    void searchWithinDistance(int x, int y, int distance);
    
    /**
     * Delete a value
     * 
     * @param id id to delete
     * @return if it is deleted
     */
    boolean delete(int id);


}
