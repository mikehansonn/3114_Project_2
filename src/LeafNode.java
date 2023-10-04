/**
 * Leaf node for the Bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public class LeafNode implements Bintree {
    private Seminar record;
    
    
    public LeafNode(Seminar record) {
        this.record = record;
    }

    /**
     * Returns the sem ID
     * 
     * @return the id
     */
    public int getId() {
        return record.id();
    }

    @Override
    public Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height) {
        InternalNode newNode = new InternalNode(new EmptyNode(), new EmptyNode());
        newNode.insert(this.record, !vertical, x0, y0, width, height);
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
}