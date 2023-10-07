
/**
 * Implement 5 trees, containing
 * bintree and BST to load and
 * store data of seminar classes
 * with ease of access for the 
 * future
 */

// On my honor:
// - I have not used source code obtained from another current or
//   former student, or any other unauthorized source, either
//   modified or unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.

/**
 * The class containing the main method.
 *
 * @author mikehanson matt02
 * @version 9/25/23
 */
public class SemSearch {
    private int worldsize;
    private BinarySearchTree<Integer, Seminar> semTree;
    private BinarySearchTree<Integer, Seminar> costTree;
    private BinarySearchTree<String, Seminar> dateTree;
    private BinarySearchTree<String, Seminar> keywordTree;
    private Bintree bintree;

    /**
     * Constructor for SemSearch
     * 
     * @param worldsize size of the BinTree
     */
    public SemSearch(int worldsize) {
        semTree = new BinarySearchTree<>();
        costTree = new BinarySearchTree<>();
        dateTree = new BinarySearchTree<>();
        keywordTree = new BinarySearchTree<>();
        bintree = new Bintree(0, 0, worldsize, worldsize);
        this.worldsize = worldsize;
    }

    /**
     * Insert the seminar
     * 
     * @param sem to insert
     * @param id  to insert
     */
    public void insertSeminar(Seminar sem, int id) {
        if (sem.x() < 0 
            || sem.y() < 0 
            || sem.x() >= worldsize 
            || sem.y() >= worldsize) {
            System.out.println(
                "Insert FAILED - Bad x, y coordinates: " 
                + sem.x() + ", " + sem.y());
            return;
        }
        if (semTree.contains(id)) {
            System.out.println(
                "Insert FAILED - There is already a record with ID "
                 + id);
            return;
        }
        System.out.println(
            "Successfully inserted record with ID " + id);
        System.out.println(sem.toString());
        semTree.insert(id, sem);
        costTree.insert(sem.cost(), sem);
        dateTree.insert(sem.date(), sem);
        // call the insert to the location tree
        for (String word : sem.keywords()) {
            keywordTree.insert(word, sem);
        }
        bintree.insert(sem);
    }

    /**
     * Delete a seminar
     * 
     * @param id id tag
     */ 
    public void deleteSeminar(int id) {
        if (!semTree.contains(id)) {
            System.out.println(
                "Delete FAILED -- There is no record with ID "
                 + id);
            return;
        }
        TreeNode<Integer, Seminar> node = semTree.delete(id, id);
        System.out.println(
            "Record with ID " 
            + id 
            + " successfully deleted from the database");
        costTree.delete(node.getValue().cost(), id);
        dateTree.delete(node.getValue().date(), id);
        String[] keywords = node.getValue().keywords();
        for (String keyword : keywords) {
            keywordTree.delete(keyword, id);
        }
    }

    
    /**
     * Search for a seminar
     * 
     * @param array data of what to search
     */
    public void searchSeminar(String[] array) {
        if (array[1].equals("ID")) {
            int id = Integer.parseInt(array[2]);
            if (!semTree.contains(id)) {
                System.out.println(
                        "Search FAILED -- There is no record with ID " + id);
                return;
            }
            System.out.println(
                "Found record with ID " + id + ":");
            semTree.search(id, id);
        } 
        else if (array[1].equals("cost")) {
            int lower = Integer.parseInt(array[2]);
            int higher = Integer.parseInt(array[3]);
            System.out.println(
                "Seminars with costs in range "
                 + lower + " to " + higher + ":");
            costTree.search(lower, higher);
        }
        else if (array[1].equals("date")) {
            System.out.println(
                "Seminars with dates in range "
                 + array[2] + " to " + array[3] + ":");
            dateTree.search(array[2], array[3]);
        } 
        else if (array[1].equals("keyword")) {
            System.out.println(
                "Seminars matching keyword "
                 + array[2] + ":");
            keywordTree.search(array[2], array[2]);
        }
        else { 
            System.out.print(
                "Seminars within " 
                 + array[4] + " units of "
                 + array[2] + ", " 
                 + array[3] + ":\n"); 
            int x = Integer.parseInt(array[2]); 
            int y = Integer.parseInt(array[3]);
            int distance = Integer.parseInt(array[4]); 
            bintree.searchWithinDistance(x, y, distance);      
        }
    }

    /**
     * Print different seminars
     * 
     * @param type what type to print
     */
    public void printSeminar(String type) {
        if (type.equals("date")) {
            System.out.print("Date Tree:\n");
            System.out.print(dateTree.toString());
        } 
        else if (type.equals("keyword")) {
            System.out.print("Keyword Tree:\n");
            System.out.print(keywordTree.toString());
        } 
        else if (type.equals("location")) {
            System.out.print("Location Tree:\n");
            System.out.print(bintree.toString());
        }
        else if (type.equals("cost")) {
            System.out.print("Cost Tree:\n");
            System.out.print(costTree.toString());
        } 
        else {
            System.out.print("ID Tree:\n");
            System.out.print(semTree.toString());
        }
    }

    /**
     * the main fucntion 
     * 
     * @param args Command line parameters
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int worldSize = Integer.parseInt(args[0]);
        String filename = args[1];
        SemSearch search = new SemSearch(worldSize);
        CommandFileParser parser = new CommandFileParser(filename, search);
        parser.readCommands();
    }
}
