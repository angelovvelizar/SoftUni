package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        String command = sc.nextLine();
        Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e + 1).toArray();

        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e * 2).toArray();

        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e - 1).toArray();

        Consumer<int[]> print = array -> Arrays.stream(array).forEach(e -> System.out.print(e + " "));

        while (!command.equals("end")) {
            if (command.equals("add")) {
                numbers = add.apply(numbers);
            } else if (command.equals("multiply")) {
                numbers = multiply.apply(numbers);
            } else if (command.equals("subtract")) {
                numbers = subtract.apply(numbers);
            } else if (command.equals("print")) {
                print.accept(numbers);
                System.out.println();
            }
            command = sc.nextLine();
        }
    }
}

