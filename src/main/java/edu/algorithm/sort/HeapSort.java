package edu.algorithm.sort;

public class HeapSort implements Sort {

    public void sort(int[] array) {

        // go through all array elements to create heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }

        // at this point heap created
        // put top element to the end of array
        for (int i = array.length - 1; i >= 0; i--) {
            // swap elements
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            maxHeapify(array, 0, i);
        }
    }

    // Restore basic max-heap property:
    // Parent node value >= child nodes value
    private void maxHeapify(int[] array, int parentNode, int heapSize) {
        int maxValueNode = parentNode;
        int leftChild = 2 * parentNode + 1;
        int rightChild = 2 * parentNode + 2;

        if (leftChild < heapSize && array[leftChild] > array[parentNode])
            maxValueNode = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[parentNode])
            maxValueNode = rightChild;

        if (maxValueNode != parentNode) {
            // swap elements
            int tmp = array[maxValueNode];
            array[maxValueNode] = array[parentNode];
            array[parentNode] = tmp;
            // continue heapify
            maxHeapify(array, maxValueNode, heapSize);
        }
    }

    // Restore basic min-heap property:
    // Parent node value >= child nodes value
    private void minHeapify(int[] array, int parentNode, int heapSize) {
        int maxValueNode = parentNode;
        int leftChild = 2 * parentNode + 1;
        int rightChild = 2 * parentNode + 2;

        if (leftChild < heapSize && array[leftChild] < array[parentNode])
            maxValueNode = leftChild;
        if (rightChild < heapSize && array[rightChild] < array[parentNode])
            maxValueNode = rightChild;

        if (maxValueNode != parentNode) {
            // swap elements
            int tmp = array[maxValueNode];
            array[maxValueNode] = array[parentNode];
            array[parentNode] = tmp;
            // continue heapify
            maxHeapify(array, maxValueNode, heapSize);
        }
    }

}
