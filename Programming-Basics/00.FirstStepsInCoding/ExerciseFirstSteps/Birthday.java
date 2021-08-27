package FirstStepsInCoding.ExerciseFirstSteps;
import java.util.Scanner;
public class Birthday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rent = Integer.parseInt(sc.nextLine());
        double cakePrice = rent * 20/100;
        double drinks = cakePrice - (cakePrice * 45/100);
        double animator = rent / 3;
        double moneyNeeded = cakePrice + drinks + animator + rent;
        System.out.println(moneyNeeded);


    }
}
