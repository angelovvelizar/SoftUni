package MoreExercises;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        String command = sc.nextLine();
        while(!command.equals("Done")){
            String[] tokens = command.split(" ");
            String commandType = tokens[0];
            switch (commandType){
                case "TakeOdd":
                    StringBuilder rawPassword = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if(i % 2 != 0){
                            rawPassword.append(password.charAt(i));
                        }
                    }
                    password = rawPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substringToRemove = password.substring(index, index + length);
                    password = password.replaceFirst(substringToRemove,"");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if(password.contains(substring)){
                        password = password.replace(substring,substitute);
                        System.out.println(password);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }


            command = sc.nextLine();
        }
        System.out.println("Your password is: " + password);

    }
}
