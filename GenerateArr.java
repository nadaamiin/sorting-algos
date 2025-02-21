import java.util.concurrent.ThreadLocalRandom;

public class GenerateArr {
    int size;
    int[] arr;
    public GenerateArr(int size) {
        this.size = size;
        arr = new int[size];
    }
    public void generate() {
        for (int i = 0; i < size; i++) {
            // Generate numbers from 1 to 20
            arr[i] = ThreadLocalRandom.current().nextInt(1, 21);
            System.out.println(arr[i] + ", ");
        }
    }
}
