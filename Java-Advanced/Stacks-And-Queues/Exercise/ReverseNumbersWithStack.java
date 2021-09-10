package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();*/

        String[] numbers = sc.nextLine().split("\\s+");

        ArrayDeque<String> stack  = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(number);
        }

        /*while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }*/

        System.out.println(String.join(" ", stack));


    }
}
