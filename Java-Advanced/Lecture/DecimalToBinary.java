package Lecture;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if(number == 0){
            System.out.println(number);
            return;
        }

        while(number > 0){
            int binaryToAdd = number % 2;
            binaryNumber.push(binaryToAdd);
            number = number / 2;
        }
        while(!binaryNumber.isEmpty()){
            System.out.print(binaryNumber.pop());
        }
    }
}
