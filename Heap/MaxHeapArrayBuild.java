package Heap;

public class MaxHeapArrayBuild {
    private void maxHeapify(int arr[],int size,int index) {
        int leftChildidx = (2 * index + 1);
        int rightChildidx = (2 * index + 2);
        int largest = index;
        if (leftChildidx < size && arr[leftChildidx] > arr[largest]) {
            largest = leftChildidx;
        }
        if (rightChildidx < size && arr[rightChildidx] > arr[largest]) {
            largest = rightChildidx;
        }

        if (largest != index) {
            swap(arr,index, largest);
            maxHeapify(arr,size,largest);
        }
    }

    private void swap(int arr[],int fpos, int spos) {
        int temp;
        temp = arr[fpos];
        arr[fpos] = arr[spos];
        arr[spos] = temp;
    }

    public void getMax(int arr[]) {
        System.out.println(arr[0]);
    }
    public void buildMaxHeap(int arr[],int size){
        for(int i=size/2-1;i>=0;i--){
            maxHeapify(arr, size, i);
        }
    }

    public static void main(String[] args) {
        MaxHeapArrayBuild pq = new MaxHeapArrayBuild();
        int arr[] = { 10, 30, 20, 40, 50, 70, 30, 80 };
        int size = arr.length;
        pq.buildMaxHeap(arr, size);
        pq.getMax(arr);
    }

}
