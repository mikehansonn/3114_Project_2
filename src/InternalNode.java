
// InternalNode Class
public class InternalNode implements Bintree {
    private Bintree left, right;
    
    // implement once the Leaf has been implemented 
    public InternalNode(Bintree left, Bintree right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height) {
        return left;
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