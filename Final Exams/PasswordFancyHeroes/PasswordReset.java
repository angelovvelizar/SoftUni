package PasswordFancyHeroes;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();


        String command = sc.nextLine();
        while(!command.equals("Done")){
            String[] commandData = command.split(" ");
            String commandType = commandData[0];
            switch (commandType){
                case "TakeOdd":
                    StringBuilder updatedPassword = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if(i % 2 != 0){
                           updatedPassword.append(password.charAt(i));
                        }
                    }
                    password = updatedPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandData[1]);
                    int length = Integer.parseInt(commandData[2]);
                    String substringToRemove = password.substring(index,index + length);
                    password = password.replaceFirst(substringToRemove,"");
                    /*StringBuilder newPassword = new StringBuilder(password);
                    password = newPassword.delete(index, index + length).toString();*/
                    System.out.println(password);
                    break;
                case "Substitute":
                    String oldSubstring = commandData[1];
                    String newSubstring = commandData[2];
                    if(password.contains(oldSubstring)){
                        password = password.replace(oldSubstring,newSubstring);
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
