package ConditionsMoreExercises;

import java.util.Scanner;

public class Pipes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int volume = sc.nextInt();
        int firstDebit = sc.nextInt();
        int secondDebit = sc.nextInt();
        double hoursMissing = sc.nextDouble();
        double firstPipe = firstDebit * hoursMissing;
        double secondPipe = secondDebit * hoursMissing;
        double totalVolume = firstPipe + secondPipe;
        if (totalVolume <= volume){
            double percentFull = 100 *totalVolume / volume;
            double firsPipePercent = 100 * firstPipe / totalVolume;
            double secondPipePercent = 100 * secondPipe / totalVolume;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%", percentFull, firsPipePercent, secondPipePercent);
        }else if (totalVolume > volume){
            double overFill = totalVolume - volume;
            System.out.printf("For %.2f hours the pool overflow with %.2f liters", hoursMissing, overFill);

        }
    }
}
