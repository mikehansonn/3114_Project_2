/**
 * Generic TreeNode class for BST and Bintree
 * 
 * @author mikehanson
 * @version 9/15/23
 */
public class TreeNode<K, V extends Comparable<V>> {
    private K key;
    private V value;
    private TreeNode<K, V> left;
    private TreeNode<K, V> right;

    /**
     * Constructor for the treenode
     * 
     * @param key key setter
     * @param value value setter
     */
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Setter for the key
     * 
     * @param key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Sets the generic value
     * 
     * @param value value replacement
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Sets the left node
     * 
     * @param left left replacement
     */
    public void setLeft(TreeNode<K, V> left) {
        this.left = left;
    }

    /**
     * Sets the right node
     * 
     * @param right right replacement
     */
    public void setRight(TreeNode<K, V> right) {
        this.right = right;
    }

    /**
     * Getter for the key
     * 
     * @return the key
     */
    public K getKey() {
        return this.key;
    }
    
    /**
     * Getter for the value
     * 
     * @return value
     */
    public V getValue() {
        return this.value;
    }

    /**
     * Getter for left node
     * 
     * @return left node
     */
    public TreeNode<K, V> getLeft() {
        return this.left;
    }

    /**
     * Getter for right node
     * 
     * @return right node
     */
    public TreeNode<K, V> getRight() {
        return this.right;
    }
}
