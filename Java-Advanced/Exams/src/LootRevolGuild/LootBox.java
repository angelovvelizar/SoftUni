package LootRevolGuild;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] firstBox = getAsArray(sc);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(firstBox).forEach(queue::offer);

        int[] secondBox = getAsArray(sc);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(secondBox).forEach(stack::push);

        int collectionSum = 0;
        while(!queue.isEmpty() && !stack.isEmpty()){
            int firstBoxItem = queue.peek();
            int secondBoxItem = stack.pop();
            int sum = firstBoxItem + secondBoxItem;

            if(sum % 2 == 0){
                collectionSum += sum;
                queue.poll();
            }else{
                queue.offer(secondBoxItem);
            }

            if(queue.isEmpty()){
                System.out.println("First lootbox is empty");
            }else if(stack.isEmpty()){
                System.out.println("Second lootbox is empty");
            }
        }

        if(collectionSum >= 100){
            System.out.println("Your loot was epic! Value: " + collectionSum);
        }else{
            System.out.println("Your loot was poor... Value: " + collectionSum);
        }
    }

    private static int[] getAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
