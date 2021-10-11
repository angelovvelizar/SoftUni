package BoquetsCookingUniversity;

import java.util.*;

public class Bouquets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tulips = getInputAsArray(sc);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(tulips).forEach(tulipsStack::push);

        int[] daffodils = getInputAsArray(sc);
        ArrayDeque<Integer> daffodilsQue = new ArrayDeque<>();
        Arrays.stream(daffodils).forEach(daffodilsQue::offer);

        int bouquetsMade = 0;
        int sumOfLeftOutFlowers = 0;

        while(!tulipsStack.isEmpty() && !daffodilsQue.isEmpty()){
            int currentTulips = tulipsStack.pop();
            int currentDaffodils = daffodilsQue.poll();
            int sum = currentTulips + currentDaffodils;

            if(sum == 15){
                bouquetsMade++;
            }else if(sum > 15){
                while(sum > 15){
                    sum -= 2;
                    if(sum == 15){
                        bouquetsMade++;
                    }else if(sum < 15){
                        sumOfLeftOutFlowers += sum;
                    }
                }
            }else{
                sumOfLeftOutFlowers += sum;
            }
        }

        bouquetsMade += (sumOfLeftOutFlowers / 15);

        if(bouquetsMade >= 5){
            System.out.println("You made it! You go to the competition with " + bouquetsMade + " bouquets!");
        }else{
            int bouquetsNeeded = 5 - bouquetsMade;
            System.out.println("You failed... You need more " + bouquetsNeeded + " bouquets.");
        }

    }

    private static int[] getInputAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
