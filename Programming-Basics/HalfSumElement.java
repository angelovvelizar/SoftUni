package ForLoop;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if(number > max){
                max = number;
            }
            sum += number;
        }
        int sumWithoutMaxNumber = sum - max;
        if(max == sumWithoutMaxNumber){
            System.out.println("Yes");
            System.out.println("Sum = " + max);
        }else{
            int diff = Math.abs(max - sumWithoutMaxNumber);
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}
