/**
 * Leaf node for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public class LeafNode implements BintreeInterface {
    private LinkedList<Seminar> recordList;
    
    /**
     * Constructor for the leafnode
     * 
     * @param recordList the new list
     */
    public LeafNode(LinkedList<Seminar> recordList) {
        this.recordList = recordList;
    }

    /**
     * Size of the internal list
     * 
     * @return size of list
     */
    public int size() {
        return recordList.size();

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
        Seminar testSem = recordList.getData(); 

        if (newRecord.x() == testSem.x() && newRecord.y() == testSem.y()) {
            recordList.add(newRecord, newRecord.id());
            return this;
        }

        InternalNode newNode = new InternalNode(
                new EmptyNode(), new EmptyNode());
        for (Seminar sem : recordList.toSemArray()) {
            newNode.insert(sem, vertical, x0, y0, width, height);
        }
        newNode.insert(newRecord, vertical, x0, y0, width, height); 
        return newNode;
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
            for (Seminar sem : recordList.toSemArray()) {
                if (isWithinDistance(x, y, sem.x(), sem.y(), distance)) {
                    System.out.print("Found a record with key value " + sem.id() + " at " + sem.x() + ", " + sem.y() + "\n");
                }
            }
        }
        return nodesVisited;

    }

    /**
     * Determines if Point is within Distance
     * 
     * @param x1, y1      Coordinates of the search point.
     * @param x2, y2  Coordinates of leafNode data
     * @param distance  search distance
     * @return          if seminar is within distance
     */
    private boolean isWithinDistance(int x1, int y1, int x2, int y2, int distance) { 
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= distance; 

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
    public BintreeInterface delete(int x, int y, int x0, int y0, int width, int height, boolean vertical, int id) {
        for (Seminar sem : recordList.toSemArray()) {
            if(sem.id() == id) {
                recordList.remove(id); 
                if (recordList.isEmpty()) {
                    return new EmptyNode();
                }
            }
        }
    
        return this; 
          
    }

    /**
     * ToString for the records
     * @return string
     */
    public String toString() {
        return recordList.toLinkedString();
    } 
}