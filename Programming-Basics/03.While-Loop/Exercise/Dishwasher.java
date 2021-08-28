package WhileLoop.Exercise;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bottlesDetergent = Integer.parseInt(sc.nextLine());

        int detergentMl = bottlesDetergent * 750;
        int totalDetergent = 0;
        int detergentPlate = 5;
        int detergentPot = 15;
        int dishCounter = 0;
        int plates = 0;
        int pots = 0;

        while(totalDetergent < detergentMl){
            String input = sc.nextLine();
            if(input.equals("End")){
                break;
            }
            int currentWashing = Integer.parseInt(input);
            dishCounter++;
            if(dishCounter % 3 == 0){
                totalDetergent += currentWashing *  detergentPot;
                pots += currentWashing;
            }else{
                totalDetergent += currentWashing * detergentPlate;
                plates += currentWashing;
            }
        }
        if(detergentMl < totalDetergent){
            int detergentNeeded = totalDetergent - detergentMl ;
            System.out.printf("Not enough detergent, %d ml. more necessary!", detergentNeeded);
        }else{
            int detergentLeft = detergentMl - totalDetergent;
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", plates,pots);
            System.out.printf("Leftover detergent %d ml.", detergentLeft);

        }

    }
}
