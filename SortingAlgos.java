import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingAlgos {
    int[] arr;
    int n;
    // Variable to count comparisons of the algorithm
    private int comparisons;
    // Variable to count swaps/shifts of the algorithm
    private int swaps;
    private long executionTime;

    public SortingAlgos(int[] arr) {
        // Store the copy of the original array to keep its structure
        this.arr = Arrays.copyOf(arr, arr.length);
        n = arr.length;
    }

    // Function to print array
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

    public void selectionSort() {
        System.out.println("""
                            
                            **Selection Sort**
                            Finds the smallest element in the array and swaps it with the first unsorted element.
                            ------------------------------------------------------------------------------------""");
        printArr("The original");
        long startTime = System.nanoTime();
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int least = i;
            System.out.println("Step " + (i + 1) + ": Finding minimum from index " + i);
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[least]) {
                    comparisons++;
                    least = j;
                }
            }
            if (least != i) {
                System.out.println("Swapping " + arr[i] + " with " + arr[least]);
                int temp = arr[least];
                arr[least] = arr[i];
                arr[i] = temp;
                swaps++;
            }else {
                System.out.println("---No swapping happened here---");
            }

            printArr("Edited");
            System.out.println();
        }
        long endTime = System.nanoTime();
        executionTime = endTime - startTime;
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println("""
                            \nTime Complexity analysis:
                            Best Case: O(n^2)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");

        System.out.println("Execution Time: " + executionTime + " nanoseconds");
        System.out.println("------------------------------------");
    }

    // Function for insertion sort
    public void insertionSort() {
        System.out.println("""
    
    **Insertion Sort**
    Builds a sorted array one element at a time by shifting larger elements to the right. Best for nearly sorted data.
    ------------------------------------------------------------------------------------------------------------------""");
        printArr("The original");
        long startTime = System.nanoTime();
        comparisons = 0;
        swaps = 0;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            System.out.println("Step " + i + ": Inserting " + temp + " of index " + i + " into the sorted subarray");

            // Flag to check shifting
            boolean shifted = false;
            while (j >= 0 && arr[j] > temp) {
                comparisons++;
                arr[j + 1] = arr[j];
                swaps++;
                j--;
                shifted = true;
            }
            arr[j + 1] = temp;

            if (!shifted) {
                System.out.println("No shifting happened here");
            } else {
                System.out.println("Shifting elements to insert " + temp);
            }
            printArr("Edited");
            System.out.println();
        }

        long endTime = System.nanoTime();
        printArr("\nThe final");
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Shifts: " + swaps);
        System.out.println("""
                            \nTime Complexity analysis:
                            Best Case: O(n)
                            Worst Case: O(n^2)
                            Average Case: O(n^2)""");

        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("------------------------------------");
    }

    // Function for bubble sort
    public void bubbleSort() {
        System.out.println("""
        
        **Bubble Sort**
        Repeatedly swaps adjacent elements if they are in the wrong order. Simple but inefficient for large lists.
        ---------------------------------------------------------------------------------------------------------""");
        printArr("The original");
        long startTime = System.nanoTime();
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            // Flag to check shifting
            boolean swapped = false;
            System.out.println("Pass " + (i + 1) + ":");
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
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

    // Function for shell sort
    public void shellSort() {
        System.out.println("""
        
        **Shell Sort**
        An improved version of insertion sort that uses gap-based sorting to move elements faster.
        ------------------------------------------------------------------------------------------""");
        printArr("The original");
        long startTime = System.nanoTime();
        comparisons = 0;
        swaps = 0;
        int step = 0;

        // Start with a large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("Step " + ++step + ": Gap = " + gap + ":");
            // Apply insertion sort for this gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                // Flag to check shifting
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

    // Function for merge sort data
    public void mergeSort() {
        System.out.println("""
        
        **Merge Sort**
        A divide-and-conquer algorithm that splits the array into halves, sorts them, and merges them back.
        --------------------------------------------------------------------------------------------------""");
        printArr("The original");

        comparisons = 0;
        swaps = 0;

        long startTime = System.nanoTime();
        mergeRec(arr, 0, arr.length - 1);
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

    // The Recursive part of Merge Sort
    private void mergeRec(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Dividing: Left(" + left + " to " + mid + "), Right(" + (mid + 1) + " to " + right + ")");

            mergeRec(arr, left, mid);
            mergeRec(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // The main merge function
    private void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr;
        int[] rightArr = new int[rightSize];

        // Make a copy of the left side of the array
        leftArr = IntStream.range(0, leftSize).map(i -> arr[left + i]).toArray();
        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        System.out.println("\nMerging: Left Part " + Arrays.toString(leftArr) + " & Right Part " + Arrays.toString(rightArr));

        int i = 0, j = 0, k = left;

        // The merge process
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

        // Copy elements of leftArr
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy elements of rightArr
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        System.out.println("Merged: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
    }

    // Function to compare between any 2 algorithms
    public void compareSort(String algo1, String algo2) {
        int[] array = Arrays.copyOf(arr, arr.length);

        // Run the first algorithm chosen by user
        System.out.println("\n** Comparing " + algo1 + " vs " + algo2 + " **");
        System.out.println("------------------------------------");
        System.out.println(algo1 + " is executed");
        comparisons = 0;
        swaps = 0;
        executionTime = 0;
        sortByAlgo(algo1, array);
        long time1 = executionTime;
        int comp1 = comparisons;
        int swap1 = swaps;

        // Run the second algorithm chosen by user
        System.out.println(algo2 + " is executed");
        comparisons = 0;
        swaps = 0;
        executionTime = 0;
        sortByAlgo(algo2, array);
        long time2 = executionTime;
        int comp2 = comparisons;
        int swap2 = swaps;

        // Display Results
        System.out.println("\n** Performance Comparison **");
        System.out.printf("%-20s %-15s %-15s %-15s%n", "Algorithm", "Time (ns)", "Comparisons", "Swaps/Shifts");
        System.out.printf("%-20s %-15d %-15d %-15d%n", algo1, time1, comp1, swap1);
        System.out.printf("%-20s %-15d %-15d %-15d%n", algo2, time2, comp2, swap2);
        System.out.println("---------------------------------------------------------------");
    }

    private void sortByAlgo(String algo, int[] array) {
        arr = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();

        // To prevent the messages of the function from displaying as an output
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            public void write(int b) {}
        }));

        switch (algo.toLowerCase()) {
            case "bubble":
                bubbleSort();
                break;
            case "selection":
                selectionSort();
                break;
            case "insertion":
                insertionSort();
                break;
            case "merge":
                mergeSort();
                break;
            case "shell":
                shellSort();
                break;
            default:
                System.setOut(originalOut);
                System.out.println("Invalid algorithm name.");
                return;
        }

        // Restore output
        System.setOut(originalOut);
        executionTime = System.nanoTime() - startTime;
    }

}
