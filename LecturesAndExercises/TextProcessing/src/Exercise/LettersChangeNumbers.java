package Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] tokens = input.split("\\s+");
        double totalSum = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < tokens.length; i++) {
            String currentData = tokens[i];
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < currentData.length(); j++) {
                char currentSymbol = currentData.charAt(j);
                switch (currentSymbol) {
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '0':
                        number.append(currentSymbol);
                        break;
                }
            }
            currentData = currentData.replace(number, "");
            double finalNumber = Integer.parseInt(number.toString());
            char firstLetter= currentData.charAt(0);
            int firstLetterPosition = getLetterPosition(firstLetter,alphabet);
            if(isUpperCase(firstLetter)){
                finalNumber /= firstLetterPosition;
            }else{
                finalNumber *= firstLetterPosition;
            }
            char lastLetter = currentData.charAt(currentData.length() - 1);
            int lastLetterPosition = getLetterPosition(lastLetter,alphabet);
            if(isUpperCase(lastLetter)){
                finalNumber -= lastLetterPosition;
            }else{
                finalNumber += lastLetterPosition;
            }
            totalSum += finalNumber;
        }
        System.out.printf("%.2f",totalSum);
    }

    public static int getLetterPosition(char letter, String alphabet){
        String letterToString = letter + "";
        letterToString = letterToString.toLowerCase();
        return alphabet.indexOf(letterToString) + 1;
    }

    public static boolean isUpperCase(char letter){
        return Character.isUpperCase(letter);
    }
}

