package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rad = Double.parseDouble(sc.nextLine());
        double radToDeg = rad * (180 / Math.PI);
        System.out.printf("%.0f", radToDeg);
    }
}
