package Conditional;

import java.util.Scanner;

public class SleepyCat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int restDays = Integer.parseInt(sc.nextLine());
        int playDays = 365 - restDays;
        int playDaysTime = playDays * 63;
        int restDaysTime = restDays * 127;
        int totalPlayTime = playDaysTime + restDaysTime;
        if(totalPlayTime > 30000){
            System.out.println("Tom will run away");
            int minutesLeft = totalPlayTime - 30000;
            int hours = minutesLeft / 60;
            int minutes = minutesLeft % 60;
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);
        }
        else if (totalPlayTime < 30000){
            System.out.println("Tom sleeps well");
            int minutesLeft = 30000 - totalPlayTime;
            int hours = minutesLeft / 60;
            int minutes = minutesLeft % 60;

            System.out.printf("%d hours and %d minutes less for play", hours, minutes);

        }
    }
}
