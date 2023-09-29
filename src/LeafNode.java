// LeafNode Class
public class LeafNode implements Bintree {
    private Seminar record;
    
    
    public LeafNode(Seminar record) {
        this.record = record;
    }

    @Override
    public void insert(Seminar newRecord, boolean vertical) {
        // Insert logic here
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