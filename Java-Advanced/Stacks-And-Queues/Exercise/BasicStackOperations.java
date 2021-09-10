package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nsx = sc.nextLine().split("\\s+");
        String[] numbers = sc.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(nsx[0]); i++) {
            stack.push(Integer.parseInt(numbers[i]));
        } 

        for (int i = 0; i < Integer.parseInt(nsx[1]); i++) {
            stack.pop();
        }

        if(stack.isEmpty()){
            System.out.println("0");
            return;
        }

        int x = Integer.parseInt(nsx[2]);

        if (stack.contains(x)){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(stack));
        }
    }
}
