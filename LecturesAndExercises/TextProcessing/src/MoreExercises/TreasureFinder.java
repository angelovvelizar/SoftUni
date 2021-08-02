package MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] key = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = sc.nextLine();

        while(!input.equals("find")){
            StringBuilder treasure = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                int currentSymbolAscii = input.charAt(i) - key[i];
                treasure.append((char)currentSymbolAscii);
                if(i == key.length - 1){
                    String substringToRemove = input.substring(0,i + 1);
                   input = input.replace(substringToRemove, "");
                    i = -1;
                }
            }
            String treasureType = treasure.substring(treasure.indexOf("&") + 1,treasure.lastIndexOf("&"));
            String coordinates = treasure.substring(treasure.indexOf("<") + 1, treasure.lastIndexOf(">"));
            System.out.printf("Found %s at %s%n",treasureType,coordinates);
            treasure.setLength(0);

            input = sc.nextLine();
        }
    }
}
