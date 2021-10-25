package Exercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Stack stack = null;
        String line = sc.nextLine();

        while(!line.equals("END")){
            String[] commandParts = line.split(" |, ");
            String command = commandParts[0];
            switch (command){
                case "Push":
                    int[] elements = Stream.of(commandParts).skip(1).mapToInt(Integer::parseInt).toArray();
                    stack = new Stack(elements);
                    break;
                case "Pop":
                    try {
                        stack.Pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            line = sc.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            for (Integer number : stack) {
                System.out.println(number);
            }
        }
    }

}
