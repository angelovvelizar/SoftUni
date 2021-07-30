package Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        double totalSum = 0;
        String regex = ">>([A-Z][A-Za-z]+)<<(\\d+.*\\d*)!(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Bought furniture: ");
        while(!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                System.out.println(matcher.group(1));
                int quantity = Integer.parseInt(matcher.group(3));
                double purchasePrice = quantity * Double.parseDouble(matcher.group(2));
                totalSum += purchasePrice;
            }
            input = sc.nextLine();
        }
        System.out.printf("Total money spend: %.2f",totalSum);
    }
}
