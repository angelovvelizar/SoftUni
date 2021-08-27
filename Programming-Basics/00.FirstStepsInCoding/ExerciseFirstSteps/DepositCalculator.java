package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class DepositCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double depositSum = Double.parseDouble(sc.nextLine());
        int depositDate = Integer.parseInt(sc.nextLine());
        double yearIncrease = Double.parseDouble(sc.nextLine());
        double sumPerMonth = (depositSum * yearIncrease / 100) / 12;
        double finalSum = depositSum + depositDate * sumPerMonth;

        System.out.println(finalSum);

    }
}
