package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> findSmallest = array -> getSmallestElement(array);


        System.out.println(findSmallest.apply(numbers));
    }

    public static int getSmallestElement(int[] numbers) {
        int smallestElement = Integer.MAX_VALUE;
        int bestIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= smallestElement) {
                smallestElement = numbers[i];
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}

