package PasswordFancyHeroes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarCodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String regex = "@[#]+[A-Z][A-Za-z0-9]{4,}[A-Z]@[#]+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String barcode = sc.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            StringBuilder currentProductGroup = new StringBuilder();
            if(!matcher.find()){
                System.out.println("Invalid barcode");
            }else{
                    String numberRegex = "\\d";
                    Pattern numberPattern = Pattern.compile(numberRegex);
                    Matcher numberMatcher = numberPattern.matcher(matcher.group());
                    while(numberMatcher.find()){
                        currentProductGroup.append(numberMatcher.group());
                    }
                    if(currentProductGroup.length() == 0){
                        currentProductGroup.append("00");
                    }
                System.out.println("Product group: " + currentProductGroup);
            }
        }
    }
}
