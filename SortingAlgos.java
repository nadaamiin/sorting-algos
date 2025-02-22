public class SortingAlgos {
    int[] arr;
    public SortingAlgos(int[] arr) {
        GenerateArr gen = new GenerateArr();
        this.arr = arr;
        printArr();
    }

    public void printArr(){
        System.out.print("Your array is: (");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

}
