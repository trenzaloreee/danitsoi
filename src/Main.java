import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        System.out.println("privet");
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.out.println(Arrays.toString(reverseArray(arr)));

    }

    public static int[] reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

}
