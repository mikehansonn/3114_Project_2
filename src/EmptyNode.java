/**
 * Empty Node class
 * 
 * @author mikehanson matt02
 * @version 10/5/23
 */
public class EmptyNode implements BintreeInterface {
    /**
     * Empty constructor for this 
     * class
     */
    public EmptyNode() {
    }

    @Override
    public BintreeInterface insert(
            Seminar newRecord, 
            boolean vertical, 
            int x0, 
            int y0, 
            int width, 
            int height) {
        LinkedList<Seminar> list = new LinkedList<>();
        list.add(newRecord, newRecord.id());
        return new LeafNode(list);
    }

    @Override
    public int searchWithinDistance(
        int x, 
        int y,
        int distance, 
        int x0, 
        int y0, 
        int width, 
        int height, 
        int nodesVisited, 
        boolean vertical) {
        if (intersects(x, y, distance, x0, y0, width, height)) {
            nodesVisited++;
        }
        return nodesVisited;
    }

    @Override
    public boolean delete(int id) {
        //nothing yet
        return false;
    }
}
