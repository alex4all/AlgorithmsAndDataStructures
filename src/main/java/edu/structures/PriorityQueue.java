package edu.structures;

public class PriorityQueue {

    private final int[] array;
    private int heapSize;
    private final Heap.Heapify heapify;

    public PriorityQueue(int capacity) {
        this.array = new int[capacity];
        this.heapSize = 0;
        this.heapify = new Heap.MinHeapify();
    }

    public int peek() {
        if (heapSize > 0) {
            return array[0];
        }
        throw new IllegalStateException("Queue is empty");
    }

    public int pool() {
        if (heapSize > 0) {
            int root = array[0];
            array[0] = array[heapSize - 1];
            heapSize--;
            heapify.heapify(array, 0, heapSize);
            return root;
        }
        throw new IllegalStateException("Queue is empty");

    }

    public void add(int arg) {
        if (heapSize >= array.length) {
            throw new IllegalStateException("Queue is full");
        }
        heapSize++;
        array[heapSize - 1] = arg;
        for (int i = heapSize - 1; i >= 0; ) {
            int parent = i / 2;
            if (array[i] < array[parent]) {
                Heap.swap(array, i, parent);
                i = parent;
            } else
                break;
        }
    }

}
