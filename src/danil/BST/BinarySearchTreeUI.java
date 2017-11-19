package danil.BST;

import danil.MaxHeapPriorityQueue.MaxHeapPriorityQueue;
import danil.Patient;

import java.util.List;
import java.util.Scanner;

import static danil.MaxHeapPriorityQueue.MaxHeapPriorityQueue.MaxHeapInsert;

/**
 * Created by danil on 11/16/17.
 */
public class BinarySearchTreeUI {

    BinarySearchTree tree = new BinarySearchTree();

    public BinarySearchTreeUI(){
        this.tree = new BinarySearchTree();
    }
    // addPatient inserts a new patient in the list
    public void addPatient(int priority,String name){
        PatientNode patient = new PatientNode(priority,name);
        tree.insert(patient);
        System.out.print("Patient was successfully added in the line. Name: "+name+" Patient's priority: "+priority+"\n\nYour input: ");
    }

    // removeMaxPatient removes the patient with the highest priority from the list
    public void removePatient(int priority){
        tree.delete(priority);
        System.out.print("\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order
    public void sortPatients(){
        tree.sort();
        System.out.print("\n\nYour input: ");
    }

    public void UI(){

        System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to remove a patient by priority number\nEnter 3 to see sorted patients based on their priority\nEnter 4 to exit the program\n\nYour input is: ");
        while(true){
            Scanner reader = new Scanner(System.in);
            int a = reader.nextInt();
            switch(a){
                // Case will call to Add new patient
                case 1: Scanner inputName = new Scanner(System.in);
                    System.out.print("Enter patient's name: ");
                    String name = inputName.next();
                    Scanner inputPriority = new Scanner(System.in);
                    System.out.print("Assign priority: ");
                    int priority = inputPriority.nextInt();
                    addPatient(priority,name);
                    break;
                case 2: Scanner inputPriorityDelete = new Scanner(System.in);
                        System.out.print("Patient to delete with priority: ");
                        int priorityDelete = inputPriorityDelete.nextInt();
                        removePatient(priorityDelete);
                    break;
                case 3: sortPatients();
                    break;
                case 4: System.out.print("\nClosing the program!");
                    return;
            }
        }
    }
}
