package WhileLoop;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int sum = 0;
        while(sum < number){
            int newNumber = Integer.parseInt(sc.nextLine());
            sum += newNumber;
        }
        System.out.println(sum);
    }
}
