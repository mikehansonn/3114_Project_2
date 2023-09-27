/**
 * Abstract BST implementaion
 * 
 * @author mikehanson matt02
 * @version 9/25/23
 * 
 * @param <K> key class
 * @param <V> value
 */
public class BinarySearchTree<K extends Comparable<K>, V> {
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
     * @param key  key to insert
     */
    public void insert(K key, V data) {
        root = insertHelp(root, key, data);
    }

    /**
     * The recursive call for insert
     * 
     * @param node root node
     * @param key  key to insert
     * @param data data to insert
     * @return the new root node
     */
    private TreeNode<K, V> insertHelp(TreeNode<K, V> node, K key, V data) {
        if (node == null) {
            node = new TreeNode<K, V>(key, data);
        } 
        else if (node.getKey().compareTo(key) >= 0) {
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
    public TreeNode<K, V> delete(K key) {
        return deleteHelp(root, key);
    }

    /**
     * The recursive help for the delete function
     * 
     * @param node node we are att
     * @param key  key to delete
     * @return the new root node
     */
    public TreeNode<K, V> deleteHelp(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().compareTo(key) > 0) {
            node.setLeft(deleteHelp(node.getLeft(), key));
        } 
        else if (node.getKey().compareTo(key) < 0) {
            node.setRight(deleteHelp(node.getRight(), key));
        } 
        else { // at correct node
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();
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
     * @return the max node
     */
    private TreeNode<K, V> getmax(TreeNode<K, V> node) {
        if (node.getRight() == null)
            return node;
        return getmax(node.getRight());
    }

    /**
     * Delete the max node in the branch
     * 
     * @param node root node
     * @return new root node
     */
    private TreeNode<K, V> deletemax(TreeNode<K, V> node) {
        if (node.getRight() == null)
            return node.getLeft();
        node.setRight(deletemax(node.getRight()));
        return node;
    }

    /**
     * The general search method
     * 
     * @param lower  lower bound
     * @param higher bound
     */
    public void search(K lower, K higher) {
        searchHelp(root, lower, higher);
    }

    /**
     * Recursion for the search method
     * 
     * @param node   root node
     * @param lower  lower bound
     * @param higher bound
     */
    private void searchHelp(TreeNode<K, V> node, K lower, K higher) {
        if (node == null) {
            return;
        }
        if (node.getKey().compareTo(lower) >= 0 && node.getKey().compareTo(higher) <= 0) {
            System.out.print(node.getValue().toString() + "\n");
        }
        if (node.getKey().compareTo(lower) <= 0) {
            searchHelp(node.getRight(), lower, higher);
        } else if (node.getKey().compareTo(higher) >= 0) {
            searchHelp(node.getLeft(), lower, higher);
        }
    }

    /**
     * The general contains method
     * 
     * @param value find value
     * @return the key of given value
     */
    public boolean contains(K value) {
        return containsHelp(root, value);
    }

    /**
     * Recursion for the contains method
     * 
     * @param node  root node
     * @param value value to search for
     * @return key of the node with value
     */
    private boolean containsHelp(TreeNode<K, V> node, K value) {
        if (node == null) {
            return false;
        }
        if (node.getKey().compareTo(value) == 0) {
            return true;
        }
        if (node.getKey().compareTo(value) < 0) {
            return containsHelp(node.getRight(), value);
        } 
        else {
            return containsHelp(node.getLeft(), value);
        }
    }

    /**
     * The complete inorder traversal for toString
     * 
     * @param node    root node
     * @param builder make the return
     * @param level   what level we are on
     * @param count   count variable
     */
    private void reverseInOrderTraversal(
            TreeNode<K, V> node, StringBuilder builder, int level, int[] count) {
        if (node == null) {
            for (int i = 0; i < level; i++) {
                builder.append("  ");
            }
            builder.append("null\n");
            return;
        }

        reverseInOrderTraversal(node.getRight(), builder, level + 1, count);

        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        if(node.getValue() instanceof Seminar) {
            builder.append(node.getKey()).append("\n");
        }
        else {
            builder.append(node.getValue()).append("\n");
        }
        count[0]++;

        reverseInOrderTraversal(node.getLeft(), builder, level + 1, count);
    }

    /**
     * Call the toString function
     * 
     * @return return the string
     */
    public String toString() {
        if (root == null)
            return "This tree is empty";
        StringBuilder builder = new StringBuilder();
        int[] count = new int[1];
        reverseInOrderTraversal(root, builder, 0, count);
        builder.append("Number of records: ").append(count[0]).append("\n");
        return builder.toString();
    }
}
