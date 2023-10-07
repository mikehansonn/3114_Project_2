/**
 * Interface for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public interface BintreeInterface {
    /**
     * Generic to insert a record
     * 
     * @param newRecord the new record
     * @param vertical boolean check
     * @param x0 0
     * @param y0 0
     * @param width worldsize
     * @param height worldsize
     * @return new node
     */
    BintreeInterface insert(
            Seminar newRecord, 
            boolean vertical, 
            int x0, 
            int y0, 
            int width, 
            int height); 
    
    /**
     * Search within a distance
     * @param x x to search
     * @param y y to search
     * @param distance radius
     * @param x0 0
     * @param y0 0
     * @param width worldsize
     * @param height worldsize
     * @param nodesVisited total visited
     * @param vertical boolean check
     * @return total visited
     */
    int searchWithinDistance(
        int x, 
        int y, 
        int distance, 
        int x0, 
        int y0, 
        int width, 
        int height, 
        int nodesVisited, 
        boolean vertical);
    
    /**
     * Delete a value
     * 
     * @param id id to delete
     * @return if it is deleted
     */
    boolean delete(int id);

    /**
     * Intersect method for the nodes
     * 
     * @param circleX x axis
     * @param circleY y asix
     * @param circleRadius radius
     * @param rectX 0 
     * @param rectY 0
     * @param rectWidth width
     * @param rectHeight height
     * @return if it intersects or not
     */
    default boolean intersects(int circleX, int circleY, int circleRadius, int rectX, int rectY, int rectWidth, int rectHeight) {
        int closestX = Math.max(rectX, Math.min(circleX, rectX + rectWidth));
        int closestY = Math.max(rectY, Math.min(circleY, rectY + rectHeight));
        return Math.pow(circleX - closestX, 2) + Math.pow(circleY - closestY, 2) <= Math.pow(circleRadius, 2);
    }

}
