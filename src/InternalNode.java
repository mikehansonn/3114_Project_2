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
            int xMid = (x0 + width) / 2;
            if (newRecord.x() < xMid) {
                left = left.insert(newRecord, !vertical, x0, y0, width / 2, height);
            } else {
                right = right.insert(newRecord, !vertical, xMid, y0, width, height);
            }
        } else {
            int yMid = (y0 + height) / 2;
            if (newRecord.y() < yMid) {
                left = left.insert(newRecord, !vertical, x0, y0, width, height / 2);
            } else {
                right = right.insert(newRecord, !vertical, x0, yMid, width, height);
            }
        }
        return this;
    }
    
    
    private boolean intersects(int circleX, int circleY, int circleRadius, int rectX, int rectY, int rectWidth, int rectHeight) {
        int closestX = Math.max(rectX, Math.min(circleX, rectX + rectWidth));
        int closestY = Math.max(rectY, Math.min(circleY, rectY + rectHeight));
        return Math.pow(circleX - closestX, 2) + Math.pow(circleY - closestY, 2) <= Math.pow(circleRadius, 2);
    }

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

    @Override
    public boolean delete(int id) {
        // Delete logic here
        return false;
    }
}