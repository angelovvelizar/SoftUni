package FlowerBeeVetClinic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lilies = getAsArray(sc);
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(lilies).forEach(liliesStack::push);

        int[] roses = getAsArray(sc);
        ArrayDeque<Integer> rosesQue = new ArrayDeque<>();
        Arrays.stream(roses).forEach(rosesQue::offer);

        int wreaths = 0;
        int leftOutSum = 0;
        while(!liliesStack.isEmpty() && !rosesQue.isEmpty()){
            int lili = liliesStack.peek();
            int rose = rosesQue.peek();
            int sum = lili + rose;

            if(sum == 15){
                wreaths++;
                liliesStack.pop();
                rosesQue.poll();
            }else if(sum > 15){
                while(sum > 15){
                    sum -= 2;
                    if(sum == 15){
                        wreaths++;
                        liliesStack.pop();
                        rosesQue.poll();
                    }else if (sum < 15){
                        leftOutSum += sum;
                        liliesStack.pop();
                        rosesQue.poll();
                    }
                }
            }else{
                leftOutSum += sum;
                liliesStack.pop();
                rosesQue.poll();
            }
        }

        wreaths += (leftOutSum) / 15;

        if(wreaths >= 5){
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!" );
        }else{
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }

    }

    private static int[] getAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
