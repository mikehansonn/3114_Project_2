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

    private boolean isWithinDistance(int x1, int y1, int x2, int y2, int distance) { 
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= distance; 
    }

    @Override
    public boolean delete(int id) {
        // Delete logic here
        return false;
    }

    /**
     * ToString for the records
     * @return string
     */
    public String toString() {
        return recordList.toLinkedString();
    } 
}