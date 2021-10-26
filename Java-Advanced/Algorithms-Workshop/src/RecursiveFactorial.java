import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        long factorial = calculateFactorial(number);
        System.out.println(factorial);
    }

    private static long calculateFactorial(int number) {
        if(number == 1){
            return 1;
        }

        return number * calculateFactorial(number -1);
    }
}
