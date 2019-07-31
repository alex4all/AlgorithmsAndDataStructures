package edu.algorithm.sort;

import edu.structures.Heap;

import java.util.Random;

public class QuickSort {

    private Partitioner partitioner;

    public QuickSort() {
        partitioner = new ClassicPartitioner();
    }

    public QuickSort(Partitioner partitioner) {
        this.partitioner = partitioner;
    }

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void hoareSort(int[] array) {
        if (array.length <= 1)
            return;
        qSort(array, 0, array.length - 1);
    }

    public static void qSort(int[] A, int low, int high) {
        int i = low;
        int j = high;
        int x = A[low + (high - low) / 2];
        do {
            while (A[i] < x) ++i;
            while (A[j] > x) --j;
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        //рекурсивные вызовы функции qSort
        if (low < j) qSort(A, low, j);
        if (i < high) qSort(A, i, high);
    }

    private void quickSort(int[] array, int first, int last) {
        if (first < last) {
            int mid = partitioner.partition(array, first, last);
            if (first < mid)
                quickSort(array, first, mid - 1);
            if (mid < last)
                quickSort(array, mid + 1, last);
        }
    }

    public interface Partitioner {
        int partition(int[] array, int first, int last);
    }

    public static class ClassicPartitioner implements Partitioner {
        @Override
        public int partition(int[] array, int first, int last) {
            int lastElement = array[last];
            int i = first - 1;
            for (int j = first; j < last; j++) {
                if (array[j] <= lastElement) {
                    i++;
                    Heap.swap(array, i, j);

                }
            }
            Heap.swap(array, i + 1, last);
            return i + 1;
        }
    }

    public static class RandomPartitioner implements Partitioner {
        ClassicPartitioner partitioner = new ClassicPartitioner();
        Random random = new Random();

        @Override
        public int partition(int[] array, int first, int last) {
            int i = first + random.nextInt(last - first + 1);
            Heap.swap(array, first, i);
            return partitioner.partition(array, first, last);
        }
    }


    public static class HoarePartitioner implements Partitioner {

        @Override
        public int partition(int[] array, int first, int last) {
            int firstElement = array[first];
            int i = first - 1;
            int j = last + 1;
            while (true) {
                do j--; while (array[j] <= firstElement);
                do i++; while (array[i] >= firstElement);

                if (i < j) {
                    Heap.swap(array, i, j);
                } else
                    return j;
            }
        }
    }


}
