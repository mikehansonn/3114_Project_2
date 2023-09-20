
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


public class SemSearch {
    private BinarySearchTree<Integer, Seminar> semTree; 
    private BinarySearchTree<Integer, Integer> costTree;
    private BinarySearchTree<Integer, String> dateTree;
    private BinarySearchTree<Integer, String> keywordTree;   

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

    public void insertSeminar(Seminar sem, int id) {
        semTree.insert(id, sem);
        costTree.insert(id, sem.cost());
        dateTree.insert(id, sem.date());
        for(String word : sem.keywords()) {
            keywordTree.insert(id, word);
        }
    }

    public void deleteSeminar(int id) {

    }

    public void searchSeminar(String[] array) {

    }

    public void printSeminar(String type) {
        if(type.equals("date")) {
            System.out.println(dateTree.toString());
        }
        else if(type.equals("keyword")) {
            System.out.println(keywordTree.toString());
        }
        else if(type.equals("location")) {
            //call the bintree tostring
            //System.out.println(semTree.toString());
        }
        else if(type.equals("cost")) {
            System.out.println(costTree.toString());
        }
        else if(type.equals("ID")) {
            System.out.println(semTree.toString());
        }
    }

    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        int worldSize = Integer.parseInt(args[0]);
        String filename = args[1];

    }
}
