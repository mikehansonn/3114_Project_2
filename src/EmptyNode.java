/**
 * Empty Node class
 * 
 * @author mikehanson matt02
 * @version 10/5/23
 */
public class EmptyNode implements BintreeInterface {
    /**
     * Empty constructor for this 
     * class
     */
    public EmptyNode() {
    }

    /**
     * Inserts a new Seminar into the tree.
     * 
     * @param newRecord The Seminar to insert.
     * @param vertical  Flag for vertical division.
     * @param x0, y0    Bottom-left corner coordinates.
     * @param width     Width of the bounding box.
     * @param height    Height of the bounding box.
     * @return          A new LeafNode containing the Seminar.
     */
    @Override
    public BintreeInterface insert( 
            Seminar newRecord, 
            boolean vertical, 
            int x0, 
            int y0, 
            int width, 
            int height) {
        LinkedList<Seminar> list = new LinkedList<>();
        list.add(newRecord, newRecord.id()); 
        return new LeafNode(list);
    } 
        
    
    /**
     * Searches for nodes within a given distance.
     * 
     * @param x, y      Coordinates of the search point.
     * @param distance  Search radius.
     * @param x0, y0    Bottom-left corner coordinates of bounding box.
     * @param width     Width of bounding box.
     * @param height    Height of bounding box.
     * @param nodesVisited Count of visited nodes.
     * @param vertical  Flag for vertical division.
     * @return          Updated count of visited nodes.
     */
    public int searchWithinDistance(
        int x, 
        int y,
        int distance, 
        int x0, 
        int y0, 
        int width, 
        int height, 
        int nodesVisited, 
        boolean vertical) {
        if (intersects(x, y, distance, x0, y0, width, height)) {
            nodesVisited++;
        }
        return nodesVisited;

    }

    /**
     * Deletes a node by its ID.
     * 
     * @param x, y      Coordinates of the node.
     * @param x0, y0    Top-left corner coordinates of bounding box.
     * @param width     Width of bounding box.
     * @param height    Height of bounding box.
     * @param vertical  Flag for vertical division.
     * @param id        ID of the node to delete.
     * @return          Updated tree after deletion.
     */
    @Override
    public BintreeInterface delete(int x, int y, int x0, int y0, int width, int height, boolean vertical, int id){
        return this; 
    }
}
