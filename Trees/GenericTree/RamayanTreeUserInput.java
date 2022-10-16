package Trees.GenericTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RamayanTreeUserInput {
    class Node {
        String name;
        ArrayList<Node> children;

        Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
    }

    public Node buildTreeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the first Ancestor ");
        String rootName = sc.nextLine();
        System.out.println("How many wife ancestor have ->");
        int count =sc.nextInt();
        for(int i=0;i<count;i++){
            System.out.println("Enter the "+(i+1)+" wife name");
            String wifeName= sc.next();
            rootName+=" + "+wifeName;
        }

        Queue<Node> qu = new LinkedList<>();
        Node root = new Node(rootName);
        qu.add(root);
        while (!qu.isEmpty()) {
            Node cNode = qu.poll();
            System.out.println("Enter the Number of childrens of ->" + cNode.name);
            int numChildren = sc.nextInt();
            for (int i = 0; i < numChildren; i++) {
                System.out.println("Enter the name of " + (i + 1) + "th child of " + cNode.name);
                String childName = sc.next();
                System.out.println("How many wife does "+childName+" have ?");
                int wifeCount=sc.nextInt();
                for(int j=0;j<wifeCount;j++){
                    System.out.println("Enter the name of "+(j+1)+" wife.");
                    String wifeName=sc.next();
                    childName+=" + "+ wifeName;
                }
                Node child = new Node(childName);
                cNode.children.add(child);
                qu.add(child);
            }
        }
        return root;
    }

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.name + "-->");
        for (Node child : root.children) {
            System.out.print(child.name + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            display(child);
        }
    }

    public void printTreeGph(Node root) {
        boolean[] flag = new boolean[60];
        Arrays.fill(flag, true);
        displayGraphically(root, flag, 0, false);
    }

    public void displayGraphically(Node root, boolean[] flag, int depth, boolean isLast) {
        // Condition when node is None
        if (root == null)
            return;
        // Loop to print the depths of the
        // current node
        for (int i = 1; i < depth; ++i) {
            // Condition when the depth
            // is exploring
            if (flag[i] == true) {
                System.out.print("| "
                        + " "
                        + " "
                        + " ");
            }
            // Otherwise print
            // the blank spaces
            else {
                System.out.print(" "
                        + " "
                        + " "
                        + " ");
            }
        }
        // Condition when the current
        // node is the root node
        if (depth == 0)
            System.out.println(root.name);

        // Condition when the node is
        // the last node of
        // the exploring depth
        else if (isLast) {
            System.out.print("+--- " + root.name + '\n');

            // No more childrens turn it
            // to the non-exploring depth
            flag[depth] = false;
        } else {
            System.out.print("+--- " + root.name + '\n');
        }

        int it = 0;
        for (Node child : root.children) {
            ++it;

            // Recursive call for the
            // children nodes
            displayGraphically(child, flag, depth + 1,
                    it == (root.children.size()) - 1);
        }
        flag[depth] = true;
    }

    public static void main(String[] args) {
        RamayanTreeUserInput tree = new RamayanTreeUserInput();
        Node root = tree.buildTreeUserInput();
        tree.printTreeGph(root);
    }
}
