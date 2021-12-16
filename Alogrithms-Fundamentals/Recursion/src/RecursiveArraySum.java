import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int sum = sum(array, 0);
        System.out.println(sum);
    }

    private static int sum(int[] array, int index) {
        if(index >= array.length){
            return 0;
        }

        return array[index] + sum(array, index + 1);
    }
}
