import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            double number = Double.parseDouble(sc.nextLine());
            System.out.println(getSquareRoot(number));
        }catch (NumberFormatException e){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }
    }

    private static double getSquareRoot(double number) {
        return Math.sqrt(number);
    }
}
