package Heap;

import javax.swing.text.html.HTMLDocument.RunElement;

public class MaxHeap {
    private Integer heap[];
    private int size;
    private int capasity;

    MaxHeap(int capasity) {
        this.capasity = capasity;
        this.size = 0;
        heap = new Integer[capasity];// +1 if we have to start indx from 1 or put capasity for indx 0.
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capasity;
    }

    public int size() {
        return size;
    }

    public int getMax() {
        return heap[0];
    }

    // condition for leaf
    // leaf node will start from ((size/2)+1)----to size.
    // from size/2 the nopn leaf will start
    // so we do heapiffy from size/2 to 0 not in leaf.
    public boolean isLeaf(int index) {
        if (index > size / 2 && index <= size) {
            return true;
        }
        return false;
    }

    public void resize(int capasity) {
        Integer[] temp = new Integer[2 * capasity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    // 1-> insert
    // nlogn
    public void insert(int val) {
        if (size == heap.length) {
            resize(heap.length);
        }
        heap[size] = val;
        int index = size;
        int parent = (index - 1) / 2;

        while (parent >= 0 && heap[parent] < heap[index]) {
            swap(index, parent);
            int t = parent;
            index = parent;
            parent = (t - 1) / 2;
        }

        size++;
    }

    // deleting the max
    public int removeMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size = size - 1;
        maxHeapify(0);
        return max;
    }

    // big(On)
    private void maxHeapify(int index) {
        // if(isLeaf(index)){
        // return;
        // }
        int leftChildidx = (2 * index + 1);
        int rightChildidx = (2 * index + 2);
        int largest = index;
        if (leftChildidx < size && heap[leftChildidx] > heap[largest]) {
            largest = leftChildidx;
        }
        if (rightChildidx < size && heap[rightChildidx] > heap[largest]) {
            largest = rightChildidx;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap(Integer[] arr) {
        this.heap = arr;
        this.size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void printArray() {
        while (size != 0) {
            System.out.print(getMax() + " ");
            removeMax();
        }
    }

    public static void main(String[] args) {
        MaxHeap pq = new MaxHeap(10);

        pq.insert(10);
        pq.insert(5);
        pq.insert(20);
        pq.insert(3100);
        pq.insert(30);
        pq.insert(50);
        pq.insert(500);
        pq.insert(600);
        pq.insert(700);
        pq.insert(1100);

        // Integer arr[] = { 10, 7, 11, 30, 20, 38, 2, 45 };
        // pq.buildMaxHeap(arr);
        // pq.getMax();
        // pq.removeMax();
        // pq.getMax();
        while (!pq.isEmpty()) {
            System.out.print(pq.removeMax() + " ");
        }

        // pq.printArray();
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
    }
}
