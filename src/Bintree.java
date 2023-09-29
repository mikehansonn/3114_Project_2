public interface Bintree {
    // Insert a SeminarRecord into the tree
    void insert(Seminar record, boolean vertical);
    

    // Search for SeminarRecords within a certain distance of given x, y coordinates
    void searchWithinDistance(int x, int y, int distance);
    

    // Delete a SeminarRecord from the tree based on its key
    boolean delete(int id);


}
