package danil;

import danil.BST.BinarySearchTreeUI;
import danil.HashTable.HashTableUI;
import danil.MaxHeapPriorityQueue.MaxHeapUI;

import java.util.Scanner;

public class UI {


    public static void main(String[] args) {
        MaxHeapUI maxHeap = new MaxHeapUI();
        HashTableUI hashTable = new HashTableUI();
        BinarySearchTreeUI tree = new BinarySearchTreeUI();

        System.out.print("Pick data structure: \n1) Type 1 for MaxHeapPriorityQueue\n2) Type 2 for Hash Tables\n3) Type 3 for Binary Search Tree");
        Scanner reader = new Scanner(System.in);
        String a = reader.next();

        if(a.equals("1")){
            maxHeap.UI(); // Initialize UI for MaxHeapPriorityQueue
        }
        else if(a.equals("2")){
            hashTable.UI();
        }
        else if(a.equals("3")){
            tree.UI();
        }
        else{
            System.out.print("Error: Try again!");
        }
    }
}
