/**
 * Leaf node for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public class LeafNode implements Bintree {
    private LinkedList<Seminar> recordList;
    
    
    public LeafNode(LinkedList<Seminar> recordList) {
        this.recordList = recordList;
    }

    /**
     * Returns the sem ID
     * 
     * @return the id
     */
    public int getId() {
        return recordList.getData().id(); 
    }

    @Override
    public Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height) {
        Seminar testSem = recordList.getData(); 

        if(newRecord.x() == testSem.x() && newRecord.y() == testSem.y()) {
            recordList.add(newRecord, newRecord.id());
            return this;
        }

        InternalNode newNode = new InternalNode(new EmptyNode(), new EmptyNode());
        for(Seminar sem : recordList.toSemArray()) {
            newNode.insert(sem, vertical, x0, y0, width, height);
        }
        newNode.insert(newRecord, vertical, x0, y0, width, height); 
        return newNode;
    }
    
    
    private boolean isWithinDistance(int x1, int y1, int x2, int y2, int distance) { 
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= distance; 
    }

    @Override
    public int searchWithinDistance(int x, int y, int distance, int x0, int y0, int width, int height, int nodesVisited, boolean vertical) {
        nodesVisited++;
        for (Seminar sem : recordList.toSemArray()) {
            if (isWithinDistance(x, y, sem.x(), sem.y(), distance)) {
                System.out.println("Found a record with key value " + sem.id() + " at " + sem.x() + ", " + sem.y());
            }
        }
        return nodesVisited;
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
        return recordList.toString();
    } 
}