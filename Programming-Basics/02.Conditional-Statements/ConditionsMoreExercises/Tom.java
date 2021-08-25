package ConditionsMoreExercises;

import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int restDays = sc.nextInt();
        int workDays = 365 - restDays;
        int playTime = workDays * 63 + restDays * 127;
        if(playTime > 30000){
            int minutes = playTime - 30000;
            int hours = minutes / 60;
            int minutesLeft = minutes % 60;
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutesLeft);
        } else if (playTime <= 30000){
            int minutes = 30000 - playTime;
            int hoursForPlay = minutes/60;
            int minutesForPlay = minutes % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hoursForPlay, minutesForPlay);
        }
    }
}
