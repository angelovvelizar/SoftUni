package WorldMapperPlants;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(sc.nextLine());
        String command = sc.nextLine();
        while(!command.equals("Travel")){
            String[] data = command.split(":");
            String commandType = data[0];
            switch (commandType){
                case "Add Stop":
                    int indexToInsert = Integer.parseInt(data[1]);
                    String stringToInsert = data[2];
                    if(indexToInsert >=0 && indexToInsert < stops.length()){
                        stops.insert(indexToInsert,stringToInsert);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    if((startIndex >= 0 && startIndex < stops.length()) && (endIndex >=0 && endIndex < stops.length())){
                        stops.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = data[1];
                    String newString = data[2];
                    String stopsAsString = stops.toString();
                    if (stopsAsString.contains(oldString)) {
                         stopsAsString = stopsAsString.replace(oldString,newString);
                         stops = new StringBuilder(stopsAsString);
                    }
                    System.out.println(stops);
                    break;
            }

            command = sc.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops.toString());

    }
}
