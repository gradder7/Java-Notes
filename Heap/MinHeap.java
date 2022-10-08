package Heap;

/*
 * If a node is to be inserted at a level of height H:
Complexity of adding a node is: O(1)
Complexity of swapping the nodes(upheapify): O(H)
(swapping will be done H times in the worst case scenario)
Total complexity: O(1) + O(H) = O(H)
For a Complete Binary tree, its height H = O(log N), where N represents total no. of nodes.
Therefore, Overall Complexity of insert operation is O(log N).
 */
public class MinHeap {
    private Integer heap[];
    private int size;
    private int capasity;

    MinHeap(int capasity) {
        this.capasity = capasity;
        this.size = 0;
        this.heap = new Integer[capasity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void getMin() {
        System.out.println(heap[0]);
    }

    public void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    // size always be +1 ahead
    public void insert(int value) {
        if (size == heap.length) {
            resize(heap.length);
        }
        heap[size] = value;
        int index = size;
        int parent = (index - 1) / 2;
        while (parent >= 0 && heap[parent] > heap[index]) {
            swap(index, parent);
            // int temp = parent;
            index = parent;
            parent = (index - 1) / 2;
        }
        size++;
    }

    public int removeMin() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size = size - 1;
        minHeapify(0);
        return max;
    }

    private void minHeapify(int i) {
        int leftChildidx = 2 * i + 1;
        int rightChildidx = 2 * i + 1;
        int smallest = i;
        if (leftChildidx < size && heap[i] > heap[leftChildidx]) {
            smallest = leftChildidx;
        }
        if (rightChildidx < size && heap[i] > heap[rightChildidx]) {
            smallest = rightChildidx;
        }
        // values will be swap not index
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    // to increase the size of array
    private void resize(int length) {
        Integer[] temp = new Integer[2 * capasity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void buildMinHeap(Integer arr[]) {
        this.size=arr.length;
        this.heap=arr;
        for(int i=size/2-1;i>=0;i--){
            minHeapify(i);
        }
    }

    public static void main(String[] args) {
        MinHeap pq = new MinHeap(20);
        Integer arr[] = { 10, 7, 11, 30, 20, 38, 2, 45 };
        pq.insert(10);
        pq.insert(2);
        pq.insert(30);
        pq.insert(50);
        pq.getMin();
        pq.removeMin();
        pq.getMin();
        pq.buildMinHeap(arr);
        pq.getMin();
        System.out.println(pq.size);
        System.out.println(pq.isEmpty());
        

    }

}
