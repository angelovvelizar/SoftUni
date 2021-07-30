package KeysEmojiPirates;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder rawKey = new StringBuilder(sc.nextLine());

        String input = sc.nextLine();
        while(!input.equals("Generate")){
            String[] tokens = input.split(">>>");
            String commandType = tokens[0];
            switch (commandType){
                case "Contains":
                    String substring = tokens[1];
                    if(rawKey.indexOf(substring) != -1){
                        System.out.printf("%s contains %s%n",rawKey.toString(),substring);
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substringToChange = rawKey.substring(startIndex,endIndex);
                    if(tokens[1].equals("Upper")){
                        rawKey.replace(startIndex,endIndex,substringToChange.toUpperCase());
                    }else if(tokens[1].equals("Lower")){
                        rawKey.replace(startIndex,endIndex,substringToChange.toLowerCase());
                    }
                    System.out.println(rawKey.toString());
                    break;
                case "Slice":
                    int indexFrom = Integer.parseInt(tokens[1]);
                    int indexTo = Integer.parseInt(tokens[2]);
                    rawKey.delete(indexFrom,indexTo);
                    System.out.println(rawKey.toString());
                    break;
            }
            input = sc.nextLine();
        }
        System.out.println("Your activation key is: " + rawKey.toString());
    }
}
