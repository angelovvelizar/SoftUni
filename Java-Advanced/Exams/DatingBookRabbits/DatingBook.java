package DatingBookRabbits;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] males = getAsArray(sc);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(males).forEach(stack::push);


        int[] females = getAsArray(sc);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(females).forEach(queue::offer);

        int matchesCount = 0;
        while(!queue.isEmpty() && !stack.isEmpty()){
            int currentMale = stack.peek();
            int currentFemale = queue.peek();


            if(currentMale <= 0 ){
                stack.pop();
                continue;
            }
            if(currentFemale <= 0 ){
                queue.poll();
                continue;
            }

            if(currentMale % 25 == 0){
                stack.pop();
                stack.pop();
                continue;
            }

            if(currentFemale % 25 == 0){
                queue.poll();
                queue.poll();
                continue;
            }

            if(currentMale == currentFemale){
                matchesCount++;
                stack.pop();
                queue.poll();
            }else{
                queue.poll();
                currentMale -= 2;
                stack.pop();
                stack.push(currentMale);
            }

        }

        System.out.println("Matches: " + matchesCount);

        if(stack.isEmpty()){
            System.out.println("Males left: none");
        }else{
            System.out.println("Males left: " + stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(queue.isEmpty()){
            System.out.println("Females left: none");
        }else{
            System.out.println("Females left: " + queue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static int[] getAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
