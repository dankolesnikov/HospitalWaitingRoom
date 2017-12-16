package danil.RedBlackTree;

import danil.Patient;

import java.awt.*;
import java.util.Scanner;

public class RedBlackTreeUI {
    RedBlackTree tree = new RedBlackTree();

    public RedBlackTreeUI() {
        this.tree = new RedBlackTree();
    }

    public void addPatient(int priority, String name){
        Patient temp = new Patient(priority,name);
        //PatientNode patient = new PatientNode(priority,Color.BLACK, temp);
        tree.insert(temp);
        System.out.print("\n\nYour input: ");
    }

    // removeMaxPatient removes the patient with the highest priority from the list
    public void removePatient(int priority){
        tree.deletePatient(priority);
        System.out.print("\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order
    public void sortPatients(){
        tree.sort();
        System.out.print("\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order
    public void searchPatient(int priority){
        tree.searchPatient(priority);
        System.out.print("\n\nYour input: ");
    }

    public void UI(){

        System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to remove a patient by priority number\nEnter 3 to search for a Patient: \nEnter 4 to see sorted patients based on their priority\nEnter 5 to exit the program\n\nYour input is: ");
        while(true){
            Scanner reader = new Scanner(System.in);
            int a = reader.nextInt();
            switch(a){
                // Case will call to Add new patient
                case 1:
                    Scanner inputName = new Scanner(System.in);
                    System.out.print("Enter patient's name: ");
                    String name = inputName.next();
                    Scanner inputPriority = new Scanner(System.in);
                    System.out.print("Assign priority: ");
                    int priority = inputPriority.nextInt();
                    addPatient(priority,name);
                    break;
                case 2:
                    Scanner inputPriorityDelete = new Scanner(System.in);
                    System.out.print("Patient to delete with priority: ");
                    int priorityDelete = inputPriorityDelete.nextInt();
                    removePatient(priorityDelete);
                    break;
                case 3:
                    Scanner inputPrioritySearch = new Scanner(System.in);
                    System.out.print("Patient to delete with priority: ");
                    int prioritySearch = inputPrioritySearch.nextInt();
                    searchPatient(prioritySearch);
                    break;
                case 4: sortPatients();
                    break;
                case 5: System.out.print("\nClosing the program!");
                    return;
            }
        }
    }
}
