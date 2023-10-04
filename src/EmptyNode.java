public class EmptyNode implements Bintree {
    // Constructor
    public EmptyNode() {
    }

    @Override
    public Bintree insert(Seminar newRecord, boolean vertical, int x0, int y0, int width, int height) {
        LinkedList<Seminar> list = new LinkedList<>();
        list.add(newRecord, newRecord.id());
        return new LeafNode(list);
    }

    @Override
    public void searchWithinDistance(int x, int y, int distance) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
