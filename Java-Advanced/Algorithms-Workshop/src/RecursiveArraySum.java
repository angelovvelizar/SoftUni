import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int index = 0;
        int sum = getSum(numbers, index);
        System.out.println(sum);
    }

    private static int getSum(int[] numbers, int index) {
         if(index == numbers.length - 1){
             return numbers[index];
         }

         return numbers[index] + getSum(numbers, index+1);
    }
}
