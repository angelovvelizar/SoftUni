package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        int[] dividersArray = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<Integer> divisibleNumbers = new ArrayList<>();



        for (int i = 1; i <= number; i++) {
            for (int j = 0; j < dividersArray.length; j++) {

            }
        }
    }
}
