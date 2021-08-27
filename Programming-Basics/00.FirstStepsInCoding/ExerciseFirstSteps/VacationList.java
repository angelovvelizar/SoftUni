package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class VacationList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pageNumber = Integer.parseInt(sc.nextLine());
        int pagesPerHour = Integer.parseInt(sc.nextLine());
        int daysNumber = Integer.parseInt(sc.nextLine());
        int totalTime = pageNumber / pagesPerHour;
        int hoursPerDay = totalTime / daysNumber;
        System.out.println(hoursPerDay);
    }
}
