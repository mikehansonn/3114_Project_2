/**
 * Interface for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public interface Bintree {
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
    void searchWithinDistance(int x, int y, int distance);
    
    /**
     * Delete a value
     * 
     * @param id id to delete
     * @return if it is deleted
     */
    boolean delete(int id);


}
