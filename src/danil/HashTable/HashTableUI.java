package danil.HashTable;

import danil.HashTable.HashNode;
import danil.Patient;

import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by danil on 11/18/17.
 */
public class HashTableUI {

    HashTableChained table = new HashTableChained();

    public HashTableUI(){
        this.table = new HashTableChained();
    }


    // addPatient inserts a new patient in the list
    public void addPatient(int priority,String name){
        Patient patient = new Patient(priority,name);
        table.insert(patient);
        System.out.print("\n\nYour input: ");
    }

    // removePatient removes the patient from the table
    public void removePatient(int priority){
        table.delete(priority);
        System.out.print("\n\nYour input: ");
    }

    // searchPatient search for a patient based on priority number
    public void searchPatient(int priority){
        table.searchPatient(priority);
        System.out.print("\n\nYour input: ");
    }

    // printPatients prints patient level by level from the Hash Table
    public void printPatients(){
        table.printList();
        System.out.print("\n\nYour input: ");
    }

    public void UI(){

        System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to delete a patient by priority number\nEnter 3 to search patient by a priority number\nEnter 4 to see patients\nEnter 5 to exit the program\n\nYour input is: ");
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
                case 3: Scanner inputPrioritySearch = new Scanner(System.in);
                    System.out.print("Patient to search with priority: ");
                    int prioritySearch = inputPrioritySearch.nextInt();
                    searchPatient(prioritySearch);
                    break;
                case 4: printPatients();
                    break;
                case 5: System.out.print("\nClosing the program!");
                    return;
            }
        }
    }
}
