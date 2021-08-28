package WhileLoop.Exercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goal = 10000;
        int total = 0;

        while (total < goal) {
            String input = sc.nextLine();
            if (input.equals("Going home")) {
                int wayHome = Integer.parseInt(sc.nextLine());
                total += wayHome;
                break;
            }
            int current = Integer.parseInt(input);
            total += current;
        }
        if (total >= goal) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", total - goal);
        }else{
            System.out.printf("%d more steps to reach goal.", goal - total);
        }
    }
}
