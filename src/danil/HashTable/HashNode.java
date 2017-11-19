package danil.HashTable;
import danil.Patient;
/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */

/** HashNode class implements a link for a single linked list in chained Hash Table
 */
public class HashNode {
    private int key;
    private Patient data;
    private HashNode next;

    // Constructor
    HashNode(int key, Patient data){
        this.key = key;
        this.data = data;
        this.next = null;
    }

    /* Getters */
    public int getKey(){
        return key;
    }

    public Patient getData(){
        return data;
    }

    public HashNode getNext(){
        return next;
    }

    /* Setters */

    public void setNext(HashNode next){
        this.next = next;
    }

    public void setData(Patient patient){
        this.data = patient;
    }
}
