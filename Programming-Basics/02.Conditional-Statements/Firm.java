package Conditional;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        int workersOutOfShift = Integer.parseInt(sc.nextLine());

        double trainingTime = days * 0.10;
        double workTime = (days - trainingTime) * 8;
        double hoursForWork = trainingTime * 8;
        double workFromOutOfShift = Math.floor(workersOutOfShift * (2 * days));
        double totalWorkNeeded = Math.floor(workTime + workFromOutOfShift);
        if(totalWorkNeeded >= hoursNeeded){
            System.out.printf("Yes!%.0f hours left.", totalWorkNeeded - hoursNeeded);
        }else{

            System.out.printf("Not enough time!%.0f hours needed.", hoursNeeded - totalWorkNeeded);
        }
    }
}
