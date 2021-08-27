package FirstStepsInCoding;


import java.util.Scanner;
public class YardGreening {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double meters  = sc.nextDouble();
    double price = meters * 7.61;
    double discount = price * 0.18;
    double discountPrice = price - discount;
    System.out.println("The final price is: " + discountPrice + " lv.");
    System.out.println("The discount is: " + discount + " lv.");
    }
}
