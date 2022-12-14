package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateTreeFromLevelOrder {
    
static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

    
    public static Node insertLevelOrder(Integer arr[], int i) {
        Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);
            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
    public static void printTreePreOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    public static void main(String[] args) {
        // Your code here
        // sample input->10 20 30 40 50 60
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> LIST = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            LIST.add(i);
        }
        Node root = insertLevelOrder(LIST.toArray(new Integer[LIST.size()]), 0);
        // System.out.println(root.data);
        printTreePreOrder(root);
    }
}
