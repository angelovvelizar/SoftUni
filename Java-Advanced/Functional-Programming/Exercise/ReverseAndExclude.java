package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divider = Integer.parseInt(sc.nextLine());

        Predicate<Integer> notDivisible = x -> x % divider != 0;

        Collections.reverse(numbers);

        numbers.stream()
                .filter(notDivisible).forEach(e -> System.out.print(e + " "));
    }
}
