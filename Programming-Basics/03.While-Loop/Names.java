package WhileLoop;

import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        while(!name.equals("Stop")){
            System.out.println(name);
            name = sc.nextLine();
        }
    }
}
