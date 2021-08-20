package ForLoop.MoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int currentSum = 0;
        int previousSum = 0;
        int difference = 0;
        for (int i = 1; i <= n; i++) {
            if(i == 1){
                int firstNumber = Integer.parseInt(sc.nextLine());
                int secondNumber = Integer.parseInt(sc.nextLine());
                previousSum = firstNumber + secondNumber;
            }else{
                int firstNumber2 = Integer.parseInt(sc.nextLine());
                int secondNumber2 = Integer.parseInt(sc.nextLine());
                currentSum = firstNumber2 + secondNumber2;
                if((Math.abs(currentSum - previousSum)) > difference){
                    difference = Math.abs(currentSum - previousSum);
                }
                previousSum = currentSum;
            }


        }
        if(difference > 0){
            System.out.println("No, maxdiff=" + difference);
        }else{
            System.out.println("Yes, value=" + previousSum);
        }
    }
}
