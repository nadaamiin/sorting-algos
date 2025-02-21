import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to SortMaster\n--------------------------");

        while (true){
            // Options of the program
            System.out.println("Do you want to\n1-Enter your array");
            System.out.println("2-Generate an array");
            System.out.println("3-Sorting algorithm analysis");
            System.out.println("4-Sort in ascending or descending order");
            System.out.println("5-Compare 2 Sorting Algorithms Performance");
            System.out.println("6-Search for an Element in the Sorted Array");
            System.out.println("7-Exit");
            int choice;
            GenerateArr generateArr;
            System.out.print("Enter your choice: ");
            while(true){
                try {
                    choice = scanner.nextInt();

                    if (choice < 1 || choice > 7) {
                        System.err.println("Invalid choice! Please enter a number between 1 and 7:");
                        continue;  // Restart loop
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input! Please enter a valid number:");
                    // Clear invalid input
                    scanner.nextLine();
                }
            }
            if (choice == 1) {
                generateArr = new GenerateArr();
                generateArr.createArr();
            }
            else if (choice == 2) {
                generateArr = new GenerateArr();
                generateArr.generateArr();
            }
            else if (choice == 7){
                System.out.println("Goodbye!\uD83D\uDC4B");
                break;
            }
            System.out.println("Press enter to continue...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}
