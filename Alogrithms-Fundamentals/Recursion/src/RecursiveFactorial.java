import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int fact = calculateFactorial(n);
        System.out.println(fact);
    }

    private static int calculateFactorial(int n) {
        if(n <= 0){
            return 1;
        }

        return n * calculateFactorial(n - 1);

    }
}
