package danil.BST;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */


/* BinarySearchTree class implements BST functionality including inseretion O(lgn), deletion O(lgn) and in-order traversal O(lgn) */
public class BinarySearchTree {

    PatientNode root; // Root node

    // Constructor for BST
    public BinarySearchTree() {
        root = null;
    }

    /* Delete O(lgn) method implements delete functionality for 3 cases of BST node deletion. */
    public boolean delete(int key){

        PatientNode parent = root;
        PatientNode current = root;
        boolean isLeftChild = false;

        while(current.getPriority()!=key){
            parent = current;
            if(current.getPriority()>key){
                isLeftChild = true;
                current = current.left;
            }
            else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }

        // Case 1: If node is a leaf
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }

        // Case 2: Node has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }
            else if(isLeftChild){
                parent.left = current.left;
            }
            else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }
            else if(isLeftChild){
                parent.left = current.right;
            }
            else{
                parent.right = current.right;
            }
        }

        // Case 3: Node has 2 children
        else if(current.left!=null && current.right!=null){
            // Found the minimum element in the right sub tree
            PatientNode successor = findSuccessor(current);
            if(current==root){
                root = successor;
            }
            else if(isLeftChild){
                parent.left = successor;
            }
            else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    /* findSuccessor method O(lgn) is a subroutine called by delete method that finds and returns a successor node. */
    public PatientNode findSuccessor(PatientNode delelePatientNode){

        PatientNode successor = null;
        PatientNode successorParent = null;
        PatientNode current = delelePatientNode.right;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if(successor!= delelePatientNode.right){
            successorParent.left = successor.right;
            successor.right = delelePatientNode.right;
        }
        return successor;
    }

    /* insertNode() O(lgn) is a recursive function to insert a new node in the correct position of BST. */
    public PatientNode insertNode(PatientNode root, int key, String name) {

        // Base case: if the tree is empty, return a new node.
        if (root == null) {
            root = new PatientNode(key,name);
            return root;
        }

        // Go down the tree recursively
        if (key < root.getPriority()){
            root.left = insertNode(root.left, key, name);
        }
        else if (key >= root.getPriority()){ // Allows keys to be equal on the right side to accommodate equal numbers.
            root.right = insertNode(root.right, key,name);
        }

        return root;
    }

    /* inOrderTraversal method O(n) traverses the tree and prints out in the command line. */
    public void inOrderTraversal(PatientNode root) {
        if (root != null) {
            inOrderTraversal(root.left); // Traverse recursively down the left tree
            System.out.print(root.getPriority()+" – "+root.getPatientName()+"; ");
            inOrderTraversal(root.right); // Traverse recursively down the right tree
        }
    }

    /* Utility method O(lgn) to insert a new node in the tree  */
    public void insert(PatientNode patient) {
        int key = patient.getPriority();
        String name = patient.getPatientName();
        root = insertNode(root, key, name);
    }

    /* Utility method O(lgn) to delete a node in the tree */
    public void deletePatient(PatientNode patient) {
        delete(patient.getPriority());
    }

    /* Utility method to sort a tree in the Increasing using In Order traversal O(n) */
    public void sort()  {
        inOrderTraversal(root);
    }
}
