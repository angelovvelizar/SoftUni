package Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        String firstInput = input[0];
        String secondInput = input[1];
        System.out.println(getSum(firstInput,secondInput));

    }

    public static int getSum(String firstInput, String secondInput) {
        int totalSum = 0;
        int smallerSize = Math.min(firstInput.length(), secondInput.length());
        for (int i = 0; i < smallerSize; i++) {
            totalSum += (firstInput.charAt(i) * secondInput.charAt(i));
        }
        if(firstInput.length() > secondInput.length()){
            for (int i = secondInput.length(); i < firstInput.length(); i++) {
                totalSum += firstInput.charAt(i);
            }
        }else if(secondInput.length() > firstInput.length()){
            for (int i = firstInput.length(); i < secondInput.length(); i++) {
                totalSum += secondInput.charAt(i);
            }
        }
        return totalSum;
    }
}
