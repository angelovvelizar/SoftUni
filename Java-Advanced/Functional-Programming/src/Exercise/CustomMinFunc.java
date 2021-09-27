package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> findMin = arr -> getMinNumber(arr);
        System.out.println(findMin.apply(numbers));
    }

    public static int getMinNumber(int[] numbers){
        int min = Integer.MAX_VALUE;
        for(int number : numbers){
            if(number < min){
                min = number;
            }
        }
        return min;
    }
}
