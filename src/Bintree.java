/**
 * Bintree class
 * 
 * @author mikehanson matt02
 * @version 10/5/23
 */
public class Bintree {
    private BintreeInterface root;
    private int x0;
    private int y0;
    private int width;
    private int height;
    private int nodesVisited = 0;

    /**
     * Constructor for the bintree
     * 
     * @param x0 0 coordinate
     * @param y0 0 coordinate
     * @param width worldsize
     * @param height worldsize
     */
    public Bintree(int x0, int y0, int width, int height) {
        this.root = new EmptyNode();
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }

    /**
     * The recursive insert call
     * 
     * @param newRecord new seminar to insert
     */
    public void insert(Seminar newRecord) {
        root = root.insert(newRecord, true, x0, y0, width, height);
    }

    /**
     * Search within a distance
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @param distance total radius
     */
    
    
    public void searchWithinDistance(int x, int y, int distance) {
        nodesVisited = root.searchWithinDistance(x, y, distance, x0, y0, width, height, 0, true); 
        System.out.print(nodesVisited + " nodes visited in this search\n");
    }

    /**
     * To String of the bintree
     * 
     * @return String total
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        preorderTraversal(root, build, "");
        return build.toString();
    }

    /**
     * Traversal for the tree
     * 
     * @param node node we are at
     * @param builder string builder class
     * @param spaces spaces for print
     */
    private void preorderTraversal(
            BintreeInterface node, 
            StringBuilder builder, 
            String spaces) {
        if (node instanceof EmptyNode) {
            builder.append(spaces).append("E").append("\n");
        } else if (node instanceof InternalNode) {
            builder.append(spaces).append("I").append("\n");
            spaces += "  ";
            preorderTraversal(
                    ((InternalNode) node).getLeft(), builder, spaces);
            preorderTraversal(
                    ((InternalNode) node).getRight(), builder, spaces);
        } else {
            builder.append(spaces)
                    .append("Leaf with " + ((LeafNode) node).size()
                            + " objects: " + ((LeafNode) node).toString())
                    .append("\n");
        }
    }
}
