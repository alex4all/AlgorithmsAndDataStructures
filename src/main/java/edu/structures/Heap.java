package edu.structures;

public class Heap {

    private final int[] array;
    private int heapSize;
    private final Heapify heapify;

    public Heap(int[] array, boolean max) {
        this.array = array;
        if (max) {
            heapify = new MaxHeapify();
        } else {
            heapify = new MinHeapify();
        }

        heapSize = array.length;
        // build heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    public void heapify(int[] array, int parentNode, int heapSize) {
        heapify.heapify(array, parentNode, heapSize);
    }

    public static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public static abstract class Heapify {
        public abstract void heapify(int[] array, int parentNode, int heapSize);
    }

    public static class MaxHeapify extends Heapify {
        public void heapify(int[] array, int parentNode, int heapSize) {
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
                heapify(array, maxValueNode, heapSize);
            }
        }
    }

    public static class MinHeapify extends Heapify {
        public void heapify(int[] array, int parentNode, int heapSize) {
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
                heapify(array, minValueNode, heapSize);
            }
        }
    }

}
