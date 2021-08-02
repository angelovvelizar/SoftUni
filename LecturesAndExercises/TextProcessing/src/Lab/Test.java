package Lab;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int middle = input.length() / 2;
        System.out.println(input.charAt(middle));
    }
}
