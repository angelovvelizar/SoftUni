import java.util.Scanner;
import java.util.stream.IntStream;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                printNumbers(sc);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void printNumbers(Scanner sc) {

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (isInvalid(str1, str2)) {
            throw new NumberFormatException("Invalid numbers! Try again");
        }
        int start = Integer.parseInt(str1);
        int end = Integer.parseInt(str2);

        IntStream.rangeClosed(start,end).forEach(System.out::println);
    }

    private static boolean isInvalid(String str1, String str2) {
        if (checkInput(str1) || checkInput(str2)) {
            return true;
        }
        int start = Integer.parseInt(str1);
        int end = Integer.parseInt(str2);

        return start <= 1 || end >= 100 || start >= end;
    }

    private static boolean checkInput(String input) {
        for (char symbol : input.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }
}
