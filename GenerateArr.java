import java.util.InputMismatchException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GenerateArr {
    static Scanner scanner = new Scanner(System.in);
    int size;
    int[] arr;

    public GenerateArr() {}
    // function to generate a random array
    public void generateArr() {
        System.out.println("Enter the size of the array");
        size = getSize();
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            // Generate random numbers from 1 to 20
            arr[i] = ThreadLocalRandom.current().nextInt(1, 21);
        }
        printArr();
    }
    // function to create array from the input of the user
    public void createArr() {
        System.out.println("Enter the size of the array");
        size = getSize();
        arr = new int[size];
        System.out.println("-> Enter your array seperated by spaces: ");
        while (true) {
            try {
                for (int i = 0; i < size; i++) {
                    int num = scanner.nextInt();
                    arr[i] = num;
                }
                break;
            }catch (Exception e){
                System.err.print("Invalid input, enter a valid number: ");
                scanner.nextLine();
            }
        }
        printArr();
    }
    // Function to print the array
    public void printArr(){
        System.out.print("Your array is: (");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
    public static int getSize() {
        int size;
        while (true) {
            try {
                size = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a valid number:");
                // Clear invalid input
                scanner.nextLine();
            }
        }
        return size;
    }

}

