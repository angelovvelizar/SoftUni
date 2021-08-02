package MoreExercises;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(sc.nextLine());

        String command = sc.nextLine();
        while(!command.equals("Travel")){
            String[] tokens = command.split(":");
            String commandType = tokens[0];
            switch (commandType){
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String toInsert = tokens[2];
                    if(isValid(index,stops)){
                        stops.insert(index, toInsert);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if(isValid(startIndex,stops) && isValid(endIndex,stops)){
                        stops.delete(startIndex,endIndex + 1);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    replaceAll(stops,oldString,newString);
                    System.out.println(stops.toString());
                    break;
            }

            command = sc.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops.toString());
    }

    public static boolean isValid(int index,StringBuilder stops){
        return index >= 0 && index < stops.length();
    }

    public static void replaceAll(StringBuilder stops, String oldString, String newString) {
        int index = stops.indexOf(oldString);
        while (index != -1) {
            stops.replace(index, index + oldString.length(), newString);
            index += newString.length(); // Move to the end of the replacement
            index = stops.indexOf(oldString, index);
        }
    }
}
