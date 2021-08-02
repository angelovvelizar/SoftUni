package MoreExercises;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder messageToReveal = new StringBuilder(sc.nextLine());
        String operation = sc.nextLine();
        while(!operation.equals("Reveal")){
            String[] data = operation.split(":\\|:");
            String operationType = data[0];
            switch (operationType){
                case "InsertSpace":
                    int indexToInsert = Integer.parseInt(data[1]);
                    messageToReveal.insert(indexToInsert," ");
                    System.out.println(messageToReveal);
                    break;
                case "Reverse":
                    StringBuilder substringToReverse = new StringBuilder(data[1]);
                    if(messageToReveal.indexOf(substringToReverse.toString()) != -1){
                        messageToReveal.delete(messageToReveal.indexOf(substringToReverse.toString()),
                                messageToReveal.indexOf(substringToReverse.toString()) + substringToReverse.length());
                        substringToReverse.reverse();
                        messageToReveal.append(substringToReverse.toString());
                        System.out.println(messageToReveal);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = data[1];
                    String replacement = data[2];
                    int index = messageToReveal.indexOf(substring);
                    while(index != - 1){
                     messageToReveal.replace(index, index + substring.length(), replacement);
                     index += replacement.length();
                     index = messageToReveal.indexOf(substring,index);
                    }
                    System.out.println(messageToReveal);
                    break;
            }
            operation = sc.nextLine();
        }
        System.out.println("You have a new text message: " + messageToReveal);
    }
}
