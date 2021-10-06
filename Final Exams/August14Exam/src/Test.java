import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 5;
        int b = a++;
        int c = ++a;
        System.out.println(c);
    }
}
