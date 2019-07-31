package edu.algorithm.sort;

public class HeapSort implements Sort {

    public void sort(int[] array) {

        // go through all array elements to create heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }

        // at this point heap created
        // put top element (max or min) to the end of heap
        // and heapify [0, n - 1]
        for (int i = array.length - 1; i >= 0; i--) {
            // swap elements
            swap(array, 0, i);
            maxHeapify(array, 0, i);
        }
    }

    // Restore basic max-heap property:
    // Parent node value >= child nodes value
    private void maxHeapify(int[] array, int parentNode, int heapSize) {
        int maxValueNode = parentNode;
        int leftChild = 2 * parentNode + 1;
        int rightChild = 2 * parentNode + 2;

        if (leftChild < heapSize && array[leftChild] > array[maxValueNode])
            maxValueNode = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[maxValueNode])
            maxValueNode = rightChild;

        if (maxValueNode != parentNode) {
            // swap elements
            swap(array, maxValueNode, parentNode);
            // continue heapify
            maxHeapify(array, maxValueNode, heapSize);
        }
    }

    // Restore basic min-heap property:
    // Parent node value >= child nodes value
    private void minHeapify(int[] array, int parentNode, int heapSize) {
        int minValueNode = parentNode;
        int leftChild = 2 * parentNode + 1;
        int rightChild = 2 * parentNode + 2;

        if (leftChild < heapSize && array[leftChild] < array[minValueNode])
            minValueNode = leftChild;
        if (rightChild < heapSize && array[rightChild] < array[minValueNode])
            minValueNode = rightChild;

        if (minValueNode != parentNode) {
            // swap elements
            swap(array, minValueNode, parentNode);
            // continue heapify
            maxHeapify(array, minValueNode, heapSize);
        }
    }

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

}
