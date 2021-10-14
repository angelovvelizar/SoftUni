package MagicBombCar;

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //first box is queue
        int[] firstBox = getAsIntArray(sc);
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(firstBox).forEach(firstBoxQueue::offer);

        //second box is stack
        int[] secondBox = getAsIntArray(sc);
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(secondBox).forEach(secondBoxStack::push);
        //sum first and last element
        //if the sum is even -> add the summed item to collection and remove both items from the boxes
        //otherwise remove the last item from the second box and add it to last pos of first box
        //stop summing when one of the boxes is empty
        List<Integer> collectedItems = new ArrayList<>();

        while(!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.pop();
            int sum = firstBoxItem + secondBoxItem;

            if(sum % 2 == 0){
                collectedItems.add(sum);
                firstBoxQueue.poll();
            }else{
                firstBoxQueue.offer(secondBoxItem);
            }
        }

        if(firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }else if(secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }


        int totalSum = collectedItems.stream().mapToInt(Integer::intValue).sum();
        if(totalSum >= 90){
            System.out.println("Wow, your prey was epic! Value: " + totalSum);
        }else{
            System.out.println("Poor prey... Value: " + totalSum);
        }

    }

    private static int[] getAsIntArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
