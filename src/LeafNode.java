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
        System.out.println("X Values = " + newRecord.x() + " " + testSem.x() + "     Y Values = " + newRecord.y() + " " + testSem.y());
        if(newRecord.x() == testSem.x() && newRecord.y() == testSem.y()) {
            System.out.println("Hit");
            recordList.add(newRecord, newRecord.id());
            return this;
        }
        InternalNode newNode = new InternalNode(new EmptyNode(), new EmptyNode());
        for(Seminar sem : recordList.toSemArray()) {
            newNode.insert(sem, !vertical, x0, y0, width, height);
        }
        newNode.insert(newRecord, !vertical, x0, y0, width, height); 
        return newNode;
    }

    @Override
    public void searchWithinDistance(int x, int y, int distance) {
        // Search logic here 
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