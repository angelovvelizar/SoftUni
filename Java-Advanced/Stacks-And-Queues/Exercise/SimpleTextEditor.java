package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] commandData = command.split("\\s+");
            String commandType = commandData[0];
            switch (commandType){
                case "1":
                    stack.push(text);
                    String textToAppend = commandData[1];
                    text += textToAppend;
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(commandData[1]);
                    text = text.substring(0,text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(commandData[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}
