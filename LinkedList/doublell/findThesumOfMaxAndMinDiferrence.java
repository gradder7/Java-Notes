package LinkedList.doublell;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class findThesumOfMaxAndMinDiferrence {
    public static int sumMaxMin(int[] arr,int n,int k){
        Deque<Integer> greater= new LinkedList<Integer>();
        Deque<Integer> smaller= new LinkedList<Integer>();
        int sum =0;
        //finding the greatest and smallest for first k window size and 
        //inserting it in deque
        for(int i=0;i<k;i++){
            //if greater than the last element in deque just remove
            while(!greater.isEmpty() && arr[i]>=arr[greater.peekLast()]){
                greater.removeLast();
            }
            //if smaller than the last element in deque just remove
            while(!smaller.isEmpty() && arr[i]<=arr[smaller.peekLast()]){
                smaller.removeLast();
            }
            //insert the given element
            greater.addLast(i);
            smaller.addLast(i);
        }
        //1 2 3 4 5 4 5
        //        -----
        // for the rest of the window to find max and min
        for(int i=k;i<n;i++){
            // here the sum of 1 st window will be cal.
            //and other windows also
            int diffMaxMinWindow =arr[greater.peekFirst()]-arr[smaller.peekFirst()];
            sum +=diffMaxMinWindow;

            //shifting of windows.
            while(!greater.isEmpty() && greater.peekFirst()<=i-k){
                greater.removeFirst();
            }
            while(!smaller.isEmpty() && smaller.peekFirst()<=i-k){
                smaller.removeFirst();
            }

            // same operation like above find max and min
            while(!greater.isEmpty() && arr[i]>=arr[greater.peekLast()]){
                greater.removeLast();
            }
            while(!smaller.isEmpty() && arr[i]<=arr[smaller.peekLast()]){
                smaller.removeLast();
            }
            greater.addLast(i);
            smaller.addLast(i);
        }
        //sum for last window to add.
        int diffMaxMinWindow =arr[greater.peekFirst()]-arr[smaller.peekFirst()];
        sum +=diffMaxMinWindow;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(sumMaxMin(arr,n,k));
    }

}
