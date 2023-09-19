
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    /**
     * Constructor for BST
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * General insert without the recusion
     * 
     * @param data data to insert
     */
    public void insert(T data) {
        root = insertFunc(root, data);
    }

    /**
     * The recursive call for insert
     * 
     * @param node root node
     * @param data data to insert
     * @return the new root node
     */
    private TreeNode<T> insertFunc(TreeNode<T> node, T data) {
        if(node.getValue() == null) {
            node = new TreeNode<T>(data);
        }
        else if(data.compareTo(node.getValue()) > 0) {
            node.setLeft(insertFunc(node.getLeft(), data));
        }
        else {
            node.setRight(insertFunc(node.getRight(), data));
        }
        return node;
    }
}
