import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());
        String command = sc.nextLine();
        while(!command.equals("End")){
            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];
            switch (commandType){
                case "Translate":
                    String charToReplace = tokens[1];
                    String charReplacement = tokens[2];
                    String replacedText = input.toString().replace(charToReplace,charReplacement);
                    input = new StringBuilder(replacedText);
                    System.out.println(input);
                    break;
                case "Includes":
                    String includedString = tokens[1];
                    if(input.indexOf(includedString) != -1){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startingString = tokens[1];
                    if(input.indexOf(startingString) == 0){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    System.out.println(input.toString().toLowerCase());
                    String lowerCaseInput = input.toString().toLowerCase();
                    input = new StringBuilder(lowerCaseInput);
                    break;
                case "FindIndex":
                    String charToFind = tokens[1];
                    System.out.println(input.lastIndexOf(charToFind));
                    break;
                case "Remove":
                    int startingIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    //String substringToRemove = input.substring(startingIndex,startingIndex + count);
                    input.delete(startingIndex,startingIndex + count);
                    System.out.println(input);
                    break;
            }


            command = sc.nextLine();
        }

    }
}
