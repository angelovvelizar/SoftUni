package ForLoop.MoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int moves = Integer.parseInt(sc.nextLine());

        double totalPoints = 0;
        int between0and9 = 0;
        int between10and19 = 0;
        int between20and29 = 0;
        int between30and39 = 0;
        int between40and50 = 0;
        int invalid = 0;
        for (int i = 0; i <moves; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if(number >= 0 && number <= 9){
                between0and9++;
                totalPoints += number * 0.2;
            }else if(number > 9 && number <= 19){
                between10and19++;
                totalPoints += number * 0.3;
            }else if(number > 19 && number <= 29){
                between20and29++;
                totalPoints += number * 0.4;
            }else if( number > 29 && number <= 39){
                between30and39++;
                totalPoints += 50;
            }else if( number > 39 && number <= 50){
                between40and50++;
                totalPoints += 100;
            }else if(number < 0 || number > 50) {
                invalid++;
                totalPoints = totalPoints / 2.0;
            }
        }
        double fPercent = (double)between0and9 / moves * 100;
        double sPercent = (double)between10and19 / moves * 100;
        double tPercent = (double)between20and29 / moves * 100;
        double foPercent = (double)between30and39 / moves * 100;
        double fiPercent = (double)between40and50 / moves * 100;
        double iPercent = (double)invalid / moves * 100;
        System.out.printf("%.2f%n",totalPoints);
        System.out.printf("From 0 to 9: %.2f%%%n",fPercent);
        System.out.printf("From 10 to 19: %.2f%%%n",sPercent);
        System.out.printf("From 20 to 29: %.2f%%%n",tPercent);
        System.out.printf("From 30 to 39: %.2f%%%n",foPercent);
        System.out.printf("From 40 to 50: %.2f%%%n",fiPercent);
        System.out.printf("Invalid numbers: %.2f%%%n",iPercent);
    }
}
