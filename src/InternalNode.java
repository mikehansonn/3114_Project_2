/**
 * Internal node for bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public class InternalNode implements BintreeInterface {
    private BintreeInterface left;
    private BintreeInterface right;
    
    /**
     * internal node constructor
     * 
     * @param left left value
     * @param right right value
     */
    public InternalNode(BintreeInterface left, BintreeInterface right) {

        this.left = left;
        this.right = right;
    }

    /**
     * Gets the left tree
     * 
     * @return left tree
     */
    public BintreeInterface getLeft() {
        return left;
    }

    /**
     * Gets the right tree
     * 
     * @return right tree
     */
    public BintreeInterface getRight() {
        return right;
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
        if (vertical) {
            int xMid = (x0 + width) / 2;
            vertical = !vertical;
            if (newRecord.x() < xMid) {
                left = left.insert(
                        newRecord, vertical, x0, y0, width / 2, height);
            } 
            else {
                right = right.insert(
                        newRecord, vertical, xMid, y0, width, height);
            }
        } 
        else {
            int yMid = (y0 + height) / 2;
            vertical = !vertical;
            if (newRecord.y() < yMid) {
                left = left.insert(
                        newRecord, vertical, x0, y0, width, height / 2);
            } 
            else {
                right = right.insert(
                        newRecord, vertical, x0, yMid, width, height);
            }
        }
        return this;
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
    @Override
    public int searchWithinDistance(int x, int y, int distance, int x0, int y0, int width, int height, int nodesVisited, boolean vertical) {
        if (intersects(x, y, distance, x0, y0, width, height)) {
            nodesVisited++;
            if (vertical) {
                int xMid = x0 + width / 2;
                nodesVisited = left.searchWithinDistance(x, y, distance, x0, y0, width / 2, height, nodesVisited, !vertical);
                nodesVisited = right.searchWithinDistance(x, y, distance, xMid, y0, width, height, nodesVisited, !vertical);
            } else {
                int yMid = y0 + height / 2;
                nodesVisited = left.searchWithinDistance(x, y, distance, x0, y0, width, height / 2, nodesVisited, !vertical);
                nodesVisited = right.searchWithinDistance(x, y, distance, x0, yMid, width, height, nodesVisited, !vertical);
            }
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
        if (vertical) {
            int xMid = (x0 + width) / 2;
            vertical = !vertical;
            if (x < xMid) {
                left = left.delete(x, y, x0, y0, width / 2, height, vertical, id);
            } 
            else {
                right = right.delete(x, y, xMid, y0, width, height, vertical, id);
            }
        } 
        else {
            int yMid = (y0 + height) / 2;
            vertical = !vertical;
            if (y < yMid) {
                left = left.delete(x, y, x0, y0, width, height / 2, vertical, id);
            } 
            else {
                right = right.delete(x, y, x0, yMid, width, height, vertical, id);
            }
        }
        return this;
   }
    
    
    
}