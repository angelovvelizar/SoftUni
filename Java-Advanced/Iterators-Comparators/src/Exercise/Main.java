package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        ListyIterator listyIterator = null;

        while(!line.equals("END")){
            String[] commandParts = line.split("\\s+");
            String commandName = commandParts[0];
            switch (commandName){
                case "Create":
                    if(commandParts.length <= 1){
                        listyIterator = new ListyIterator();
                    }else {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(commandParts, 1, commandParts.length));
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.Print();
                    break;
            }



            line = sc.nextLine();
        }
    }
}
