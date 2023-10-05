/**
 * Internal node for bintree
 * 
 * @author mikehanson matt02
 * @version 9/30/23
 */
public class InternalNode implements Bintree {
    private Bintree left, right;
    
    /**
     * internal node constructor
     * 
     * @param left left value
     * @param right right value
     */
    public InternalNode(Bintree left, Bintree right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the left tree
     * 
     * @return left tree
     */
    public Bintree getLeft() {
        return left;
    }

    /**
     * Gets the right tree
     * 
     * @return right tree
     */
    public Bintree getRight() {
        return right;
    }

    @Override
    public Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height) {
        if (vertical) {
            int xMid = x0 + width / 2;
            if (newRecord.x() < xMid) {
                left = left.insert(newRecord, !vertical, x0, y0, width / 2, height);
            } else {
                right = right.insert(newRecord, !vertical, xMid, y0, width, height);
            }
        } else {
            int yMid = y0 + height / 2;
            if (newRecord.y() < yMid) {
                left = left.insert(newRecord, !vertical, x0, y0, width, height / 2);
            } else {
                right = right.insert(newRecord, !vertical, x0, yMid, width, height);
            }
        }
        return this;
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