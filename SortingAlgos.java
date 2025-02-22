import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingAlgos {
    int[] arr;
    int n;
    int comparisons; // Added instance variable for comparisons
    int swaps;

    public SortingAlgos(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
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
        comparisons = 0;
        swaps = 0;

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
        System.out.println("""
                            \nTime Complexity analysis:
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
        comparisons = 0;
        swaps = 0;

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
        System.out.println("""
                            \nTime Complexity analysis:
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
        comparisons = 0;
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
        System.out.println("""
                            \nTime Complexity analysis:
                            Best Case: O(n)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");

        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    public void shellSort() {
        System.out.println("**Shell Sort**\n------------------");
        printArr("The original");
        long startTime = System.nanoTime();
        comparisons = 0;
        swaps = 0;
        int step = 0;

        // Start with a large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("Step " + ++step + ": Gap = " + gap + ":");
            // Perform insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                boolean shifted = false;
                System.out.println("Inserting " + temp + " into its correct position in the subarray:");
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    comparisons++;
                    System.out.println("  Comparing " + arr[j - gap] + " and " + temp + ": " +
                            arr[j - gap] + " > " + temp + "? Yes");
                    System.out.println("  Shifting " + arr[j - gap] + " to the right");
                    arr[j] = arr[j - gap];
                    swaps++;
                    shifted = true;
                }
                if (!shifted && j >= gap) {
                    System.out.println("  Comparing " + arr[j - gap] + " and " + temp + ": " +
                            arr[j - gap] + " > " + temp + "? No");
                }
                arr[j] = temp;
                if (shifted) {
                    System.out.println("  Inserted " + temp + " at index " + j);
                } else {
                    System.out.println("  So, no shifting needed for " + temp);
                }
                printArr("  Edited");
                System.out.println();
            }
        }

        long endTime = System.nanoTime();
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println("""
                            \nTime Complexity analysis:
                            Best Case: O(n log n)
                            Worst Case: O(n^2)
                            Average Case: O(n log n)""");

        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    // Merge Sort Implementation with Detailed Tracing
    public void mergeSort() {
        System.out.println("\n**Merge Sort**\n------------------");
        printArr("The original");

        comparisons = 0; // Reset counts before sorting
        swaps = 0;

        long startTime = System.nanoTime();
        mergeSortRecursive(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("\nSorted Array:");
        printArr("The final");
        System.out.println("\nTotal Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println("""
                            \nTime Complexity Analysis:");
                            Best Case: O(n log n)");
                            Worst Case: O(n log n)");
                            Average Case: O(n log n)""");

        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    // Recursive Merge Sort
    private void mergeSortRecursive(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Dividing: Left(" + left + " to " + mid + "), Right(" + (mid + 1) + " to " + right + ")");

            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge function with tracing
    private void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr;
        int[] rightArr = new int[rightSize];

        // Copying data to temporary arrays
        leftArr = IntStream.range(0, leftSize).map(i -> arr[left + i]).toArray();
        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        System.out.println("\nMerging: Left Part " + Arrays.toString(leftArr) + " & Right Part " + Arrays.toString(rightArr));

        int i = 0, j = 0, k = left;

        // Merge process
        while (i < leftSize && j < rightSize) {
            comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
                swaps++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[]
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[]
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        System.out.println("Merged: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
    }}
