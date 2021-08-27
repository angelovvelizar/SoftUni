package FirstStepsInCoding;
import java.util.Scanner;
public class PetShop {
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int dogNumber = sc.nextInt();
    int otherAnimals = sc.nextInt();
    double dogFood = 2.50;
    double otherFood = 4.0;
    double leva = (dogNumber * dogFood) + (otherAnimals * otherFood);
    System.out.println(leva + " lv.");

    }
}
