package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class UsdToBgn {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double dollar = Double.parseDouble(sc.nextLine());
        double usdToBgn = dollar * 1.79549;
        System.out.println(usdToBgn);
    }
}
