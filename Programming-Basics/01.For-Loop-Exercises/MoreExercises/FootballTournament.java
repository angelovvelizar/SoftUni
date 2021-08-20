package ForLoop.MoreExercises;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(sc.nextLine());
        int fansNumber = Integer.parseInt(sc.nextLine());

        int firstTeamFans = 0;
        int secondTeamFans = 0;
        int fansInA = 0;
        int fansInB = 0;
        int fansInV = 0;
        int fansInG = 0;
        for (int i = 0; i < fansNumber; i++) {
            String sector = sc.nextLine();
            switch (sector) {
                case "A":
                    fansInA++;
                    firstTeamFans++;
                    break;
                case "B":
                    fansInB++;
                    firstTeamFans++;
                    break;
                case "V":
                    fansInV++;
                    secondTeamFans++;
                    break;
                case "G":
                    fansInG++;
                    secondTeamFans++;
                    break;
            }

        }
        double aPercent = (double)fansInA / fansNumber * 100;
        double bPercent = (double)fansInB / fansNumber * 100;
        double vPercent = (double)fansInV / fansNumber * 100;
        double gPercent = (double)fansInG / fansNumber * 100;
        double allFans = secondTeamFans + firstTeamFans;
        double fansPercent = allFans / stadiumCapacity * 100;

        System.out.printf("%.2f%%%n",aPercent);
        System.out.printf("%.2f%%%n",bPercent);
        System.out.printf("%.2f%%%n",vPercent);
        System.out.printf("%.2f%%%n",gPercent);
        System.out.printf("%.2f%%%n",fansPercent);
    }
}
