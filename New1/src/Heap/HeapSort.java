package Heap;

import java.util.Random;


public class HeapSort {
    public static int SIZE = 10;

    public static class Heap {
        public int[] array;
        public int size;

        public Heap(int[] array) {
            super();
            this.array = array;
            this.size = array.length - 1;
        }

        public int length() {
            return array.length;
        }

        public void exchange(int i, int j) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }
    //该方法的执行前提是:两个子树都是最大堆
    public static void maxHeapify(Heap a, int i) {
        int left = i << 1;
        int right = left + 1;
        int max = i;
        if (left <= a.size && a.array[left] > a.array[i]) {
            max = left;
        }
        if (right <= a.size && a.array[right] > a.array[max]) {
            max = right;
        }
        if (max != i) {
            a.exchange(max, i);
            maxHeapify(a, max);
        }
    }

    public static void buildMaxHeap(Heap a) {
        for (int i = a.size >> 1; i > 0; i--) {
            maxHeapify(a, i);
        }
    }

    public static void heapSort(Heap a) {
        buildMaxHeap(a);
        int s = a.size;
        for (int i = s; i >= 2; i--) {
            a.exchange(i, 1);
            a.size--;
            maxHeapify(a, 1);
        }
    }

    public static int heapMaxValue(Heap a) {
        return a.array[1];
    }

    public static int poll(Heap a) throws Exception {
        if (a.size == 0) {
            throw new Exception("heap is empty!");
        }
        int max = a.array[1];
        a.array[1] = a.array[a.size--];
        maxHeapify(a, 1);
        return max;
    }

    public static void heapIncreaseKey(Heap a, int i, int key) throws Exception {
        if (a.array[i] > key) {
            throw new Exception();
        }
        a.array[i] = key;
        while (i > 1 && a.array[(i >> 1)] < key) {
            a.exchange(i, i >> 1);
            i = i >> 1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[SIZE];
        Random random = new Random(100);
        for (int i = 0; i < SIZE; i++) {
            a[i] = (SIZE - i) * (SIZE - i);
        }
        Heap array = new Heap(a);
        heapSort(array);
        for (int i = 1; i < array.length(); i++) {
            System.out.println(array.array[i]);
        }
    }
}