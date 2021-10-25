package BombsSnakeParking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //datura = 40
        //cherry = 60
        //smoke decoy = 120

        int[] bombEffects = getAsArray(sc);

        ArrayDeque<Integer> bombEffectsQue = new ArrayDeque<>();
        Arrays.stream(bombEffects).forEach(bombEffectsQue::offer);

        int[] bombCasings = getAsArray(sc);

        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(bombCasings).forEach(bombCasingsStack::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean isFilled = false;

        while(!bombEffectsQue.isEmpty() && !bombCasingsStack.isEmpty()){
            if(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3){
                isFilled = true;
                break;
            }
            int bombEffect = bombEffectsQue.peek();
            int bombCasing = bombCasingsStack.pop();
            int sum = bombCasing + bombEffect;

            switch (sum){
                case 40:
                    daturaBombs++;
                    bombEffectsQue.poll();
                    break;
                case 60:
                    cherryBombs++;
                    bombEffectsQue.poll();
                    break;
                case 120:
                    smokeDecoyBombs++;
                    bombEffectsQue.poll();
                    break;
                default:
                    bombCasing -= 5;
                    bombCasingsStack.push(bombCasing);
                    break;
            }
        }

        if(isFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if(bombEffectsQue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else{
            System.out.println("Bomb Effects: " + bombEffectsQue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(bombCasingsStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else{
            System.out.println("Bomb Casings: " + bombCasingsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);

    }

    private static int[] getAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
