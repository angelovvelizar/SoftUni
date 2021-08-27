package FirstStepsInCoding.ExerciseFirstSteps;
import javax.lang.model.element.QualifiedNameable;
import java.util.Scanner;
public class FruitMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double strawberryPrice = Double.parseDouble((sc.nextLine()));
        double bananaQuantity = Double.parseDouble((sc.nextLine()));
        double orangeQuantity = Double.parseDouble((sc.nextLine()));
        double raspberryQuantity = Double.parseDouble((sc.nextLine()));
        double strawberryQuantity = Double.parseDouble((sc.nextLine()));
        double raspberryPrice = strawberryPrice - (strawberryPrice * 50/100);
        double orangePrice = raspberryPrice - (raspberryPrice * 40/100);
        double bananaPrice = raspberryPrice - (raspberryPrice * 80/100);
        double moneyNeeded = (strawberryPrice * strawberryQuantity) + (raspberryPrice * raspberryQuantity) + (orangePrice * orangeQuantity) + (bananaPrice * bananaQuantity);
        System.out.printf("%.2f", moneyNeeded);
    }
}
