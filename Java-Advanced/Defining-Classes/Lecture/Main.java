package Lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        int id = 1;

        while(!command.equals("End")){
            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];



            switch (commandType){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(id,bankAccount);
                    System.out.println("Account ID" + id + " created");
                    id++;
                    break;
                case "Deposit":
                    int idToDeposit = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if(!bankAccounts.containsKey(idToDeposit)){
                        System.out.println("Account does not exist");
                    }else{
                        bankAccounts.get(idToDeposit).deposit(amount);
                        System.out.println("Deposited " + amount + " to " + "ID" + idToDeposit);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);

                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int idToGet = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if(!bankAccounts.containsKey(idToGet)){
                        System.out.println("Account does not exist");
                    }else{
                        System.out.printf("%.2f%n",bankAccounts.get(idToGet).getInterest(years));
                    }
                    break;
            }

            command = sc.nextLine();
        }

    }


}
