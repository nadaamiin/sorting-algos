import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to SortMaster");

        while (true){
            System.out.println("-----------------------------");
            // Options of the program
            System.out.println("First you need to have an array, So you will:\n1-Enter your array");
            System.out.println("2-Generate an array");
            System.out.println("3-Exit");

            int[] array = null;
            GenerateArr generateArr;

            int choice1 = getChoice(3);
            if (choice1 == 1) {
                generateArr = new GenerateArr();
                generateArr.createArr();
                array = generateArr.arr;
            }
            else if (choice1 == 2) {
                generateArr = new GenerateArr();
                generateArr.generateArr();
                array = generateArr.arr;
            }
            if (choice1 != 3) {
                System.out.println("Press enter to see the list of services...");
                scanner.nextLine();
                scanner.nextLine();
            }

            int choice3 = 0;
            String sort_algorithms = """
                    1-Selection sort
                    2-Insertion sort
                    3-Bubble sort
                    4-Shell sort
                    5-Merge sort""";
            if(choice1 == 1 || choice1 == 2){
                while (true){
                    System.out.println("You can now choose the service you want:");
                    System.out.println("1-Sorting algorithm analysis");
                    System.out.println("2-Compare 2 Sorting Algorithms Performance");
                    int choice2 = getChoice(2);
                    SortingAlgos sortingAlgos = new SortingAlgos(array);
                    if (choice2 == 1){
                        System.out.println("\n-->Choose a sorting algorithm:\n" + sort_algorithms);
                        int choose_algorithm = getChoice(6);
                        if (choose_algorithm == 1){
                            sortingAlgos.selectionSort();
                        }else if (choose_algorithm == 2){
                            sortingAlgos.insertionSort();
                        }else if (choose_algorithm == 3){
                            sortingAlgos.bubbleSort();
                        }else if (choose_algorithm == 4){
                            sortingAlgos.shellSort();
                        }else if (choose_algorithm == 5){
                            sortingAlgos.mergeSort();
                        }
                    } else if (choice2 == 2) {
                        System.out.println("\nChoose the first algorithm:\n" + sort_algorithms);
                        int first_algo = getChoice(6);

                        System.out.println("\nChoose the second algorithm:\n" + sort_algorithms);
                        int second_algo = getChoice(6);

                        String[] algorithms = {"selection", "insertion", "bubble", "shell", "merge"};

                        String algo1 = (first_algo >= 1 && first_algo <= 5) ? algorithms[first_algo - 1] : "";
                        String algo2 = (second_algo >= 1 && second_algo <= 5) ? algorithms[second_algo - 1] : "";

                        while (true){
                            if (first_algo == second_algo){
                                System.out.println("\nChoose another algorithm to compare with " + first_algo);
                                System.out.println(sort_algorithms);
                                second_algo = getChoice(6);
                            }else {
                                break;
                            }
                        }
                        SortingAlgos compare = new SortingAlgos(array);
                        compare.compareSort(algo1, algo2);
                    }

                    System.out.println("Do you want to:");
                    System.out.println("1-Choose another service");
                    System.out.println("2-Create an new array");
                    System.out.println("3-Exit the program");
                    choice3 = getChoice(3);
                    if (choice3 == 3 || choice3 == 2){
                        break;
                    }
                }
            }

            if (choice1 == 3 || choice3 == 3){
                System.out.println("Goodbye!\uD83D\uDC4B");
                break;
            }
        }
    }

    // Function to handle the wrong choice of the user
    public static int getChoice(int range) {
        int choice;
        while(true){
            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > range) {
                    System.err.println("Invalid choice! Please enter a number between 1 and " + range + ":");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a valid number:");
                // Clear invalid input
                scanner.nextLine();
            }
        }
        return choice;
    }
}
