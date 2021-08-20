package ForLoop;

import java.util.Scanner;

public class NumberOn7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 7; i <= 997; i++) {
            if(i % 10 == 7){
                System.out.println(i);
            }
        }
    }
}
