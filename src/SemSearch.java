
/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
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
 * The 
 */
public class SemSearch {
    private BinarySearchTree<Integer, Seminar> semTree; 
    private BinarySearchTree<Integer, Seminar> costTree;
    private BinarySearchTree<String, Seminar> dateTree;
    private BinarySearchTree<String, Seminar> keywordTree;   

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
    }

    /**
     * Insert the seminar
     * 
     * @param sem to insert
     * @param id to insert
     */
    public void insertSeminar(Seminar sem, int id) {
        //check if the id exists already
        //if it does, print insert falied, else continue
        //and print the seminar
        semTree.insert(id, sem);
        costTree.insert(sem.cost(), sem);
        dateTree.insert(sem.date(), sem);
        //call the insert to the location tree
        for(String word : sem.keywords()) {
            keywordTree.insert(word, sem);
        }
    }

    /**
     * Delete a seminar
     * 
     * @param id
     */
    public void deleteSeminar(int id) {
        Seminar sem = new Seminar();
        sem.setID(id);
        TreeNode<Integer, Seminar> node = semTree.delete(id);

        if(node == null) {
            System.out.println(
                "Delete FAILED -- There is no record with ID " + id);
            return;
        }
        System.out.println("Record with ID " 
                        + id + " successfully deleted from the database");
        costTree.delete(node.getValue().cost());
        dateTree.delete(node.getValue().date());
        String[] keywords = node.getValue().keywords();
        for(String keyword : keywords) {
            keywordTree.delete(keyword);
        }
    }

    public void searchSeminar(String[] array) {
        if(array[1].equals("ID")) {

        }
        else if(array[1].equals("cost")) {

        }
        else if(array[1].equals("date")) {
            
        }
        else if(array[1].equals("keyword")) {
            
        }
        else if(array[1].equals("location")) {
            
        }
    }

    public void printSeminar(String type) {
        if(type.equals("date")) {
            System.out.println("Date Tree:");
            System.out.println(dateTree.toString());
        }
        else if(type.equals("keyword")) {
            System.out.println("Keyword Tree:");
            System.out.println(keywordTree.toString());
        }
        else if(type.equals("location")) {
            System.out.println("Location Tree:");
            //call the bintree tostring
            //System.out.println(semTree.toString());
        }
        else if(type.equals("cost")) {
            System.out.println("Cost Tree:");
            System.out.println(costTree.toString());
        }
        else if(type.equals("ID")) {
            System.out.println("ID Tree:");
            System.out.println(semTree.toString());
        }
    }

    /**
     * @param args
     *     Command line parameters
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
