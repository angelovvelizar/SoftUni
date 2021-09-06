package WhileLoop;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String password = sc.nextLine();

        String input = "";
        while(!input.equals(password)){
            input = sc.nextLine();
            if(input.equals(password)) {
                System.out.println("Welcome " + name + "!");
            }
        }
    }
}
