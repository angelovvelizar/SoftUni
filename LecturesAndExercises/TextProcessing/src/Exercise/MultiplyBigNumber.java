package Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(sc.nextLine());
         BigInteger secondNumber = new BigInteger(sc.nextLine());

        System.out.println(firstNumber.multiply(secondNumber));

    }
}
