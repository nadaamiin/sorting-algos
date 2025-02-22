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
            if(choice1 == 1 || choice1 == 2){
                while (true){
                    System.out.println("You can now choose the service you want:");
                    System.out.println("1-Sorting algorithm analysis");
                    System.out.println("2-Sort in ascending or descending order");
                    System.out.println("3-Compare 2 Sorting Algorithms Performance");
                    System.out.println("4-Search for an Element in the Sorted Array");
                    int choice2 = getChoice(4);
                    if (choice2 == 1){
                        SortingAlgos sortingAlgos = new SortingAlgos(array);
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
    static int getChoice(int range) {
        int choice;
        while(true){
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > range) {
                    System.err.println("Invalid choice! Please enter a number between 1 and " + range + ":");
                    continue;  // Restart loop
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
