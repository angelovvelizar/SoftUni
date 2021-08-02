package Lab;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder rawKey = new StringBuilder(sc.nextLine());

        String instruction = sc.nextLine();
        while(!instruction.equals("Generate")){
            String[] tokens = instruction.split(">>>");
            String command  = tokens[0];
            switch (command){
                case "Contains":
                    String substring = tokens[1];
                    if(rawKey.indexOf(substring)== -1){
                        System.out.println("Substring not found!");
                    }else{
                        System.out.println(rawKey + " contains " + substring);
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substringToReplace = rawKey.substring(startIndex,endIndex);
                    if(upperOrLower.equals("Upper")){
                        substringToReplace = substringToReplace.toUpperCase();
                    }else if(upperOrLower.equals("Lower")){
                        substringToReplace = substringToReplace.toLowerCase();
                    }
                    rawKey.replace(startIndex,endIndex,substringToReplace);
                    System.out.println(rawKey);
                    break;
                case "Slice":
                    int startingIndex = Integer.parseInt(tokens[1]);
                    int endingIndex = Integer.parseInt(tokens[2]);
                    rawKey.delete(startingIndex,endingIndex);
                    System.out.println(rawKey);
                    break;
            }
            instruction = sc.nextLine();
        }
        System.out.println("Your activation key is: " + rawKey);
    }
}
