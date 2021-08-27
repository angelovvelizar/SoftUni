package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class FishTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt((sc.nextLine()));
        int width = Integer.parseInt((sc.nextLine()));
        int height = Integer.parseInt((sc.nextLine()));
        double percent = Double.parseDouble(sc.nextLine()) / 100;
        double aquaVolume = length * width * height;
        double litres = aquaVolume * 0.001;
        double neededLitres =  litres * (1 - percent);
        System.out.printf("%.2f", neededLitres);



    }
}
