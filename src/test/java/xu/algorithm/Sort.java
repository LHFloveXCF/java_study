package xu.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * java_study
 */
public class Sort {
    @Test
    public void heapSort2() {
        print();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int length = sourceArray.length;
        for (int i = length; i > 0; i--) {
            queue.add(sourceArray[i - 1]);
        }
        for (int i = 0; i < length; i++) {
            sourceArray[i] = queue.poll();
        }
        print();
    }

    @Test
    public void heapSort() {
        print();
        int length = sourceArray.length;
        for (int i = 0; i < length; i++) {
            heapInsert(sourceArray, i);
        }
        print();
        System.out.println();
        for (int i = length; i > 0; i--) {
            swap(sourceArray, i - 1, 0);
            heapIfy(sourceArray, i - 1);
            heapInsert(sourceArray, 0);
            // print();
        }
        print();
    }

    private void heapIfy(int[] arr, int heapSize) {
        int index = 0;
        while (index * 2 + 1 < heapSize) {
            int left = index * 2;
            int largest = left + 1 < heapSize ? arr[left] > arr[left + 1] ? left : left + 1 : left;
            if (arr[index] > arr[largest]) {
                break;
            }
            if (index != largest) {
                swap(arr, index, largest);
            }
            index = largest;
        }
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    @Test
    public void mergerSort() {
        print();
        int length = sourceArray.length;
        mergerSort(sourceArray, 0, length - 1);
        print();

    }

    private void mergerSort(int[] sourceArray, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            mergerSort(sourceArray, low, mid);
            mergerSort(sourceArray, mid + 1, high);
            merger(sourceArray, low, mid, high);
        }
    }

    private void merger(int[] sourceArray, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j =  mid + 1;
        int k = 0;
        while (i<=mid && j <= high) {
            if (sourceArray[i] < sourceArray[j]) {
                temp[k++] = sourceArray[i++];
            } else {
                temp[k++] = sourceArray[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = sourceArray[i++];
        }
        while (j<=high) {
            temp[k++] = sourceArray[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            sourceArray[low + m] = temp[m];
        }
    }

    @Test
    public void quickSort(){
        print();
        int length = sourceArray.length;
        quickSort(sourceArray, 0, length - 1);
        print();
    }

    private void quickSort(int[] sourceArray, int low, int high) {
        int pivot, pivot_pos;
        if (low < high) {
            pivot_pos = low;
            pivot = sourceArray[pivot_pos];
            for (int i=low + 1; i<=high; i++) {
                if (sourceArray[i] < pivot) {
                    pivot_pos++;
                    int temp = sourceArray[pivot_pos];
                    sourceArray[pivot_pos] = sourceArray[i];
                    sourceArray[i] = temp;
                }
            }
            int temp = sourceArray[low];
            sourceArray[low] = sourceArray[pivot_pos];
            sourceArray[pivot_pos] = temp;

            quickSort(sourceArray, low, pivot_pos - 1);
            quickSort(sourceArray, pivot_pos + 1, high);
        }
    }

    @Test
    public void bubble() {
        print();
        int length = sourceArray.length;
        for (int i = 0; i < length; i++) {
            for (int j=0; j<length - i - 1; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                }
            }
        }
        print();
    }

    @Test
    public void select() {
        print();
        int length = sourceArray.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j=i; j<length; j++) {
                if (sourceArray[minIndex] > sourceArray[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = sourceArray[i];
                sourceArray[i] = sourceArray[minIndex];
                sourceArray[minIndex] = temp;
            }
        }
        print();
    }

    @Test
    public void insert() {
        print();
        int length = sourceArray.length;
        for (int i = 1; i < length; i++) {
            for (int j=i; j>0; j--) {
                if (sourceArray[j] > sourceArray[j - 1]) {
                    int temp = sourceArray[j - 1];
                    sourceArray[j - 1] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        print();
    }

    private static final int[] sourceArray = generateArray();

    private static int[] generateArray() {
        int length = 10;
        int maxValue = (int) (Math.random() * 100);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * maxValue);
        }
        return result;
    }

    private static void print() {
        System.out.println(Arrays.toString(Sort.sourceArray));
    }
}
