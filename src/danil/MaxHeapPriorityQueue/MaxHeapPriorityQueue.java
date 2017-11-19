package danil.MaxHeapPriorityQueue;

import danil.Patient;

import java.util.*;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW1 Fall 2017
 * Professor: Dr. Mike Wu
 */

public class MaxHeapPriorityQueue {

    public static int heapSize; // Maintains the size of the Heap data structure

    /* BuildMaxHeap procedure O(n), produces a max heap from an unordered array.*/
    public static void BuildMaxHeap(List<Patient> A){
        heapSize=A.size();
        for(int i=heapSize/2;i>=1; i--){
            MaxHeapify(A,i);
        }
    }

    /* MaxHeapify O(logn) procedure, maintains the max-heap property - the parent needs to be greater than its children. */
    public static void MaxHeapify(List<Patient> A, int i){
        int largest;
        int left = 2*i;
        int right = 2*i+1;

        if (left <=heapSize-1  && A.get(left).getPriority() > A.get(i).getPriority()) {
            largest = left;
        }
        else{
            largest = i;
        }
        if (right <= heapSize-1 && A.get(right).getPriority() > A.get(largest).getPriority()){
            largest = right;
        }
        if (largest!=i){
            Collections.swap(A,i,largest);
            MaxHeapify(A,largest);
        }

    }

        /*The MAX-HEAP-INSERT, HEAP-EXTRACT-MAX, HEAP-INCREASE-KEY, and HEAP-MAXIMUM procedures, which all run O(logn) time, allow the heap data structure to implement a priority queue.*/

    /* HeapExtractMax O(logn) method provides the user with ability to extract the node with the highest priority - while maintaining MaxHeapify */
    public static Patient HeapExtractMax(List<Patient> A){
        if(heapSize==1){
            System.out.print("\nThere is only one patient in the line!");
            Patient last = A.get(0);
            A.remove(0);
            heapSize--;
            return last;
        }
        if(heapSize<1){
            System.out.print("Heap underflow");
            Patient error = new Patient(666,"error");
            return error;
        }
        Patient max = A.get(1);
        A.set(1,A.get(heapSize-1));
        A.remove(heapSize-1);
        heapSize--;
        MaxHeapify(A,1);

        return max;
    }

    /* MaxHeapInsert method procedure provides the user with ability to insert a new node in the heap while maintaining MaxHeap structure*/
    public static void MaxHeapInsert(List<Patient> A, Patient key){
        heapSize++;
        A.add(key);
        HeapIncreaseKey(A,A.size()-1,key);
    }

    /* HeapIncreaseKey is used by MaxHeapInsert method in order to set the key of this new node to its correct value and maintain the Max Heap priority r */
    public static void HeapIncreaseKey(List<Patient> A, int i, Patient key){
        if(key.getPriority()<A.get(i).getPriority()){
            System.out.print("New key is smaller than current key! ");
        }
        //A.get(i).setPriority(key.getPriority());
        while(i>1 && A.get(i/2).getPriority() < A.get(i).getPriority()){
            Collections.swap(A,i/2,i);
            i = i/2;
        }
    }
    /* HeapMaximum method returns the node with the highest priority */
    public static Patient HeapMaximum(List<Patient> A){
        if(heapSize==0){
            System.out.print("The line is empty! ");
            Patient empty = new Patient(0,"empty");
            return empty;
        }
        if(heapSize==1){
            return A.get(0);
        }
        else{
            return A.get(1);
        }
    }

    // printArray returns the List in a user friendly form
    public static void printArray(List<Patient> A){
        System.out.print("\n");
        for(int l=1;l<A.size();l++){
            String name = A.get(l).getName();
            int priority = A.get(l).getPriority();
            System.out.print(name+" "+priority+"; ");
        }
    }

    // Heapsort algorithm to sort unordered array
    public static void Sort(List<Patient> A){
        BuildMaxHeap(A);
        for(int i=heapSize-1; i>1; i--){
            Collections.swap(A,1,i);
            heapSize--;
            MaxHeapify(A,1);
        }
    }

    // printTree method print a heap in a user friendly form
    public static void printTree(List<Patient> A){
        Iterator<Patient> iterator = A.iterator();
        int i = 0;
        double levelSize = 0;
        while (iterator.hasNext()) {
            if (i == 0) {
                iterator.next();
                i++;
            }
            else {
                while (levelSize < 5) {
                    boolean tab = true;
                    double max = Math.pow(2,levelSize); // Math.sqrt() and a*a DON"T work - why?
                    while (i < max * 2 && i < 21 && iterator.hasNext()) {
                        if(levelSize == 0) {
                            System.out.print("\t\t\t\t\t\t\t");
                        }
                        if(levelSize == 1 && tab){
                            System.out.print("\t\t\t\t\t\t");
                            tab = false;
                        }
                        if(levelSize == 2 && tab){
                            System.out.print("\t\t\t\t\t");
                            tab = false;
                        }
                        Patient sample = iterator.next();
                        System.out.print(" "+sample.getPriority() + " ("+sample.getName()+")");
                        i++;
                    }
                    levelSize++;
                    System.out.println();
                    System.out.println();
                }

            }
        }
    }
}