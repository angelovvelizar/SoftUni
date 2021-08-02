package Lab;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String subStringToRemove = sc.nextLine();
        String input = sc.nextLine();
        while (input.contains(subStringToRemove)){
            input = input.replace(subStringToRemove,"");
        }
        System.out.println(input);
    }
}
