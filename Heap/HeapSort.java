package Heap;

/*
 * Auxiliary Space: O(1)

Some FAQs related to Heap Sort
->What are the two phases of Heap Sort?
The heap sort algorithm consists of two phases. In the first phase the array is converted into a max heap.
 And in the second phase the highest element is removed (i.e., the one at the tree root) 
 and the remaining elements are used to create a new max heap.

->Why Heap Sort is not stable?
Heap sort algorithm is not a stable algorithm. This algorithm is not stable because 
the operations that are performed in a heap can change the relative ordering of the equivalent keys.

->Is Heap Sort an example of “Divide and Conquer” algorithm?
Heap sort is NOT at all a Divide and Conquer algorithm. It uses a heap data structure to efficiently sort 
its element and not a “divide and conquer approach” to sort the elements.

->Which sorting algorithm is better – Heap sort or Merge Sort?
The answer lies in the comparison of their time complexity and space requirement. T
he Merge sort is slightly faster than the Heap sort. But on the other hand merge sort takes extra memory. 
Depending on the requirement, one should choose which one to use.

->Why Heap sort better than Selection sort?
Heap sort is similar to selection sort, but with a better way to get the maximum element. 
It takes advantage of the heap data structure to get the maximum element in constant time.
 */
public class HeapSort {
    // to make heap
    public void heapify(int arr[], int n, int i) {
        int leftChildidx = 2 * i + 1;
        int rightChildidx = 2 * i + 2;
        int largest = i;
        if (leftChildidx < n && arr[leftChildidx] > arr[largest]) {
            largest = leftChildidx;
        }
        if (rightChildidx < n && arr[rightChildidx] > arr[largest]) {
            largest = rightChildidx;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public void sort(int arr[], int n) {
        // convert the array in heap
        // or construct heap or build binary heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // heap sort.
        // sort the heap array which we will get
        for (int i = n - 1; i > 0; i--) {
            // first element remove and save to temp
            // put last elemnt to first in place of deleted index
            // store arr[i]-> in last index from where it was swaped to front put it deleted
            // to last.
            int temp = arr[0];
            arr[0] = arr[i];
            // stored deleted value in last
            arr[i] = temp;
            // why 0 in i ?-> because when we swap the last to first than the heap is not in
            // order so we will start doing heapify again for every iteration to make
            // greater in
            // first index of array for next iteration to make it sort...
            // i in place of size because the the current iteration has sorted the elemnt
            // now
            // sort for rest in array.
            heapify(arr, i, 0);
        }
    }

    public void swap(int arr[], int fpos, int spos) {
        int temp = arr[fpos];
        arr[fpos] = arr[spos];
        arr[spos] = temp;
    }

    public void printHeapSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void printHeapsortDecreasing(int arr[], int n) {
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int arr[] = { 100, 10, 30, 20, 40, 50, 70, 30, 80 };
        int n = arr.length;
        sort.sort(arr, n);
        sort.printHeapSort(arr, n);
        System.out.println();
        sort.printHeapsortDecreasing(arr, n);

    }
}
