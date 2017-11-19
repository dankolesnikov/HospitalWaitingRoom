package danil.HashTable;
import danil.Patient;
/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */


/** HashTableChained Class implements a hash table using closed addressing -> chaining with single Linked List
 */

public class HashTableChained {

    private final int tableSize = 11;
    private final int arraySize = tableSize+1; // Needs to be +1 -> array starts at zero
    private HashNode[] hashTable;

    // Constructor for HashTableChained class
    public HashTableChained(){
        hashTable = new HashNode[arraySize];
        initTable();
    }

    /* Utility function to fill primitive array hashTable with null. Used at initialization. */
    private void initTable() {
        for (int i = 0; i < arraySize; i++){
            hashTable[i] = null;
        }
    }

    // Returns a hash key using division approach
    public int calculateHashKey(int priority){
        int result = priority % tableSize;
        return result;
    }

    /* Insert function O(1) that inserts a new HashNode at the head of the single linked list*/
    public void insert(Patient patient){
        int key = calculateHashKey(patient.getPriority());

        if(hashTable[key] == null){ // If there are no links at the key
            hashTable[key] = new HashNode(key, patient);
            System.out.print("\nInserted at key "+key+" : "+patient.getName()+"; Priority: "+patient.getPriority());
        }
        else{
            HashNode head = hashTable[key]; // Set the head object to the first link in the list
            HashNode newRoot = new HashNode(key, patient); // Create newRoot object
            newRoot.setNext(head); // next of the newRoot now contains current head link
            hashTable[key] = newRoot; // The head of the list is now the newRoot object
            System.out.print("\nInserted after collision at key "+key+": "+patient.getName()+"; Priority: "+patient.getPriority());
        }
    }

    /* Utility function to search for a patient */
    public void searchPatient(int priority){
        Patient temp = search(priority);
        if(temp.getName().equals("Null")){
            System.out.print("\nPatient NOT found at priority: "+priority);
        }
        else{
            System.out.print("\nPatient found: "+temp.getName()+", "+temp.getPriority());
        }
    }

    /* Search function O(n) that return Patient object based on the priority number and key in the Hash Table*/
    private Patient search(int priority) {
        int key = calculateHashKey(priority); //
        Patient dummy = new Patient(priority, "Null"); // Dummy object

        if (hashTable[key] == null) {
            return dummy; // Empty key
        }
        else {
            HashNode root = hashTable[key]; // Initialize root object and set it to the first link in the list

            // Traverse the list and compare priority number of each link
            while(root != null){
                if(root.getData().getPriority()==priority){
                    return root.getData();
                }
                else{
                    root = root.getNext();
                }
            }
        }
        return dummy;
    }

    /* Delete function O(n) that deletes a Hash Node based on priority number. O(n) instead of O(1) because of chaining. */
    public void delete(int priority){
        int key = calculateHashKey(priority);
        String patientName = search(priority).getName(); // Name of the patient in question

        if (hashTable[key] == null) { // if no list at the key
            System.out.printf("\nKey doesn't exist %d",priority);
        }
        else {
            HashNode prev = hashTable[key]; // Set previous pointer to the first link in the list
            HashNode current = prev.getNext(); // Set current pointer to the 2nd link in the list

            if(prev.getData().getPriority()==priority){
                // Node in question is the head
                hashTable[key] = hashTable[key].getNext();
                System.out.print("\nDeleted patient "+patientName+" with priority: "+priority);
            }
            else{
                // Traverse the list and find the node in question
                while(current != null){ // We know certainly that the root is not our guy
                    if(current.getData().getPriority()==priority){
                        prev.setNext(current.getNext()); // Connect previous next pointer to the next node of the current
                        current = null; // Delete node in question
                        System.out.print("\nDeleted patient "+patientName+" with priority: "+priority);
                    }
                    else{
                        // Increment pointers
                        prev = prev.getNext();
                        current = prev.getNext();
                    }

                }
            }
        }
    }

    /* Utility function that prints out Hash table level by level */
    public void printList(){
        System.out.print("\nHash table by level: \n");
        for(int i = 0; i < arraySize; i++){
            if(hashTable[i] != null) {
                HashNode current = hashTable[i]; // Get the head node of the linked list at key i
                System.out.print("Level "+i+": ");
                while(current != null){
                    Patient temp = current.getData();
                    System.out.print(temp.getName()+" "+temp.getPriority()+"; ");
                    current = current.getNext();
                }
                System.out.print("\n");
            }
        }
    }

}
