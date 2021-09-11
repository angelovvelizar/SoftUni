package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nsx = sc.nextLine().split("\\s+");
        String[] numbers = sc.nextLine().split("\\s+");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(nsx[0]); i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < Integer.parseInt(nsx[1]); i++) {
            queue.poll();
        }

        if(queue.isEmpty()){
            System.out.println("0");
            return;
        }

        int x = Integer.parseInt(nsx[2]);

        if (queue.contains(x)){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(queue));
        }
    }
}
