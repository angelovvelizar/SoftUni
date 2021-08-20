package Conditional;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberMagnolias = Integer.parseInt(sc.nextLine());
        int numberHyacinth = Integer.parseInt(sc.nextLine());
        int numberRoses = Integer.parseInt(sc.nextLine());
        int numberCacti = Integer.parseInt(sc.nextLine());
        double giftPrice = Double.parseDouble(sc.nextLine());

        double magnoliasPrice = numberMagnolias * 3.25;
        double hyacinthPrice = numberHyacinth * 4;
        double rosesPrice = numberRoses * 3.50;
        double cactiPrice = numberCacti * 8;
        double totalIncome = (magnoliasPrice + hyacinthPrice + rosesPrice + cactiPrice);
        double incomeAfterTax = totalIncome - (totalIncome * 0.05);
        if(incomeAfterTax >= giftPrice){
            double moneyLeft = Math.floor(incomeAfterTax - giftPrice);
            System.out.printf("She is left with %.0f leva.", moneyLeft);
        }else{
            double moneyNeeded = Math.ceil(giftPrice - incomeAfterTax);
            System.out.printf("She will have to borrow %.0f leva.", moneyNeeded);
        }
    }
}
