package SecretMirrorNFS;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(sc.nextLine());
        String instruction = sc.nextLine();
        while(!instruction.equals("Reveal")){
            String[] tokens = instruction.split(":\\|:");

            switch (tokens[0]){
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    concealedMessage.insert(index," ");
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String substring =tokens[1];
                    if(concealedMessage.indexOf(substring) == -1){
                        System.out.println("error");
                    }else{
                       concealedMessage.delete(concealedMessage.indexOf(substring),concealedMessage.indexOf(substring) + substring.length());
                       StringBuilder reversedSubstring = new StringBuilder(substring).reverse();
                       concealedMessage.append(reversedSubstring);
                        System.out.println(concealedMessage);
                    }
                    break;
                case "ChangeAll":
                    String substringToReplace = tokens[1];
                    String replacement = tokens[2];
                    int substringIndex = concealedMessage.indexOf(substringToReplace);
                    while(substringIndex != -1){
                        concealedMessage.replace(substringIndex,substringIndex + substringToReplace.length(),replacement);
                        substringIndex += replacement.length();
                        substringIndex = concealedMessage.indexOf(substringToReplace,substringIndex);
                    }
                    System.out.println(concealedMessage);
                    break;
            }
            instruction = sc.nextLine();
        }
        System.out.println("You have a new text message: " + concealedMessage);
    }
}
