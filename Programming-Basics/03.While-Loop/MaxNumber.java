package WhileLoop;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int max = Integer.MIN_VALUE;
        while(!text.equals("Stop")){
            int number = Integer.parseInt(text);
            if(number > max){
                max = number;
            }
            text = sc.nextLine();
        }
        System.out.println(max);
    }
}
