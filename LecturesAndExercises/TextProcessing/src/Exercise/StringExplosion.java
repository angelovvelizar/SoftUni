package Exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder field = new StringBuilder(sc.nextLine());
        int bomb = 0;
        for (int i = 0; i < field.length(); i++) {
            if(bomb > 0 && field.charAt(i) != '>'){
                field.deleteCharAt(i);
                bomb--;
                i--;
            }else if(field.charAt(i) == '>'){
                bomb += Integer.parseInt(field.charAt(i + 1) + "");
            }
        }
        System.out.println(field);
    }
}
