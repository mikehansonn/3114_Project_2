public class BinTreeManager {
    private Bintree root;
    private int x0, y0, width, height;  // Dimensions of the root

    // Constructor
    public BinTreeManager(int x0, int y0, int width, int height) {
        this.root = new EmptyNode();
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }

    public void insert(Seminar newRecord) {
        root = root.insert(newRecord, true, x0, y0, width, height);
    }
    
    
    public void searchWithinDistance(int x, int y, int distance) {
        root.searchWithinDistance(x, y, distance); 
    }

    public String toString() {
        StringBuilder build = new StringBuilder(); 
        preorderTraversal(root, build, "");
        return build.toString();
    }

    private void preorderTraversal(Bintree node, StringBuilder builder, String spaces) {
        if(node instanceof EmptyNode) {
            builder.append(spaces).append("E").append("\n");
        }
        else if(node instanceof InternalNode) {
            builder.append(spaces).append("I").append("\n");
            spaces += "  ";
            preorderTraversal(((InternalNode) node).getLeft(), builder, spaces);
            preorderTraversal(((InternalNode) node).getRight(), builder, spaces);
        }
        else {
            builder.append(spaces).append("Leaf with objects: " + ((LeafNode) node).toString()).append("\n");
        }
    }
}
