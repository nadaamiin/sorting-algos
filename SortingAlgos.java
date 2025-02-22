import java.util.Arrays;

public class SortingAlgos {
    int[] arr;
    int n;

    public SortingAlgos(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
        this.arr = arr;
        n = arr.length;
    }

    public void printArr(String word){
        System.out.print(word + " array is: (");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

    public void bubbleSort() {
        System.out.println("**Bubble Sort**\n------------------");
        printArr("The original");
        long startTime = System.nanoTime();
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            System.out.println("Pass " + (i + 1) + ":");
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                    System.out.println("Swapping " + arr[j] + " and " + arr[j + 1]);
                }
            }
            printArr("Edited");
            if (!swapped) {
                System.out.println("No swapping happened in this pass");
            }
            System.out.println();
        }

        long endTime = System.nanoTime();
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println();
        System.out.println("""
                            Time Complexity analysis:
                            Best Case: O(n)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    public void selectionSort() {
        System.out.println("**Selection Sort**\n------------------");
        printArr("The original");
        long startTime = System.nanoTime();
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            System.out.println("Step " + (i + 1) + ": Finding minimum from index " + i);
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    comparisons++;
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                System.out.println("Swapping " + arr[i] + " with " + arr[minIndex]);
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps++;
            }else {
                System.out.println("---No swapping happened here---");
            }

            printArr("Edited");
            System.out.println();
        }
        long endTime = System.nanoTime();
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println();
        System.out.println("""
                            Time Complexity analysis:
                            Best Case: O(n^2)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    public void insertionSort() {
        System.out.println("**Insertion Sort**\n------------------");
        printArr("The original");
        long startTime = System.nanoTime();
        int comparisons = 0;
        int shifts = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            System.out.println("Step " + i + ": Inserting " + key + " into the sorted subarray");

            boolean shifted = false;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                shifts++;
                j--;
                shifted = true;
            }
            arr[j + 1] = key;

            if (!shifted) {
                System.out.println("No shifting happened here");
            } else {
                System.out.println("Shifting elements to insert " + key);
            }
            printArr("Edited");
            System.out.println();
        }

        long endTime = System.nanoTime();
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Shifts: " + shifts);
        System.out.println();
        System.out.println("""
                            Time Complexity analysis:
                            Best Case: O(n)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }
}
