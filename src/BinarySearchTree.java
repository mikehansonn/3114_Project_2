
/**
 * need insert, delete, search, print(reverse inorder)
 */
public class BinarySearchTree<K, V extends Comparable<V>> {
    private TreeNode<K, V> root;

    /**
     * Constructor for BST
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * General insert without the recursion
     * 
     * @param data data to insert
     * @param key key to insert
     */
    public void insert(K key, V data) {
        root = insertHelp(root, key, data);
    }

    /**
     * The recursive call for insert
     * 
     * @param node root node
     * @param key key to insert
     * @param data data to insert
     * @return the new root node
     */
    private TreeNode<K, V> insertHelp(TreeNode<K, V> node, K key, V data) {
        if(node.getValue() == null) {
            node = new TreeNode<K, V>(key, data);
        }
        else if(node.getValue().compareTo(data) >= 0)  {
            node.setLeft(insertHelp(node.getLeft(), key, data));
        }
        else {
            node.setRight(insertHelp(node.getRight(), key, data));
        }
        return node;
    }
    
    // 
    
    /**
     * Starter delete a node from the tree
     * 
     * @param key key of the value to delete
     * @return return the deleted
     */
    public V delete(V value) {
        return deleteHelp(root, value).getValue();
    }

    /**
     * The recursive help for the delete function
     * 
     * @param node node we are att
     * @param key key to delete
     * @return the new root node
     */
    public TreeNode<K, V> deleteHelp(TreeNode<K, V> node, V value) {
        if(node == null) {
            return null;
        }
        if(node.getValue().compareTo(value) > 0) {
            node.setLeft(deleteHelp(node.getLeft(), value));
        }
        else if(node.getValue().compareTo(value) < 0) {
            node.setRight(deleteHelp(node.getRight(), value));
        }
        else { // at correct node
            if(node.getLeft() == null) return node.getRight();
            else if(node.getRight() == null) return node.getLeft();
            else {
                TreeNode<K, V> temp = getmax(node.getLeft());
                node.setValue(temp.getValue());
                node.setKey(temp.getKey());
                node.setLeft(deletemax(node.getLeft()));
            }
        }
        return node;
    }

    /**
     * Get the max node in a branch.
     * 
     * @param node root node
     * @return  the max node
     */
    private TreeNode<K, V> getmax(TreeNode<K, V> node) {
        if (node.getRight() == null) return node;
        return getmax(node.getRight());
    }

    /**
     * Delete the max node in the branch
     * 
     * @param node root node
     * @return new root node
     */
    private TreeNode<K, V> deletemax(TreeNode<K, V> node) {
        if(node.getRight() == null) return node.getLeft();
        node.setRight(deletemax(node.getRight()));
        return node;
    }

    /**
     * The general search method
     * 
     * @param value value to find 
     * @return the key of given value
     */
    public K search(V value) {
        return searchHelp(root, value);
    }

    /**
     * Recursion for the search method
     * 
     * @param node root node
     * @param value value to search for
     * @return key of the node with value
     */
    private K searchHelp(TreeNode<K, V> node, V value) {
        if(node == null) {
            return null;
        }
        if(node.getValue().compareTo(value) > 0) {
            return searchHelp(node.getLeft(), value);
        }
        else if(node.getValue().compareTo(value) < 0) {
            return searchHelp(node.getRight(), value);
        }
        else {
            return node.getKey();
        }
    }

    public String toString() {
        if(root == null) return "This tree is empty";
        StringBuilder builder = new StringBuilder();



        return builder.toString();
    }
}
