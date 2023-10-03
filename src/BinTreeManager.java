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
}
