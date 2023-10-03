/**
 * Interface for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */

public interface Bintree {
    // Insert a SeminarRecord into the tree
    Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height); 
    
    
    /**
     * Search within a distance
     * 
     * @param x x value search
     * @param y y value search
     * @param distance total distance
     */
    void searchWithinDistance(int x, int y, int distance);
    
    /**
     * Delete a value
     * 
     * @param id id to delete
     * @return if it is deleted
     */
    boolean delete(int id);


}
