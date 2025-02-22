import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GenerateArr {
    Scanner scanner = new Scanner(System.in);
    int size;
    int[] arr;

    public GenerateArr() {}
    public void generateArr() {
        System.out.println("Enter the size of the array");
        size = scanner.nextInt();
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            // Generate numbers from 1 to 20
            arr[i] = ThreadLocalRandom.current().nextInt(1, 21);
        }
        printArr();
    }
    public void createArr() {
        System.out.println("Enter the size of the array");
        size = scanner.nextInt();
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
}
