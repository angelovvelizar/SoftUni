package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

        Consumer<String> printNames = name -> System.out.println("Sir " + name);


        names.forEach(printNames);
    }
}
