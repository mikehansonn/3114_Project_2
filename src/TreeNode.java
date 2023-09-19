/**
 * Generic TreeNode class for BST and Bintree
 * 
 * @author mikehanson
 * @version 9/15/23
 */
public class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Constructor for the treenode
     * 
     * @param value value setter
     */
    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Sets the generic value
     * 
     * @param value value replacement
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Sets the left node
     * 
     * @param left left replacement
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Sets the right node
     * 
     * @param right right replacement
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Getter for the value
     * 
     * @return value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Getter for left node
     * 
     * @return left node
     */
    public TreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Getter for right node
     * 
     * @return right node
     */
    public TreeNode<T> getRight() {
        return this.right;
    }
}
