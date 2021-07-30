package MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class ThePianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> piecesInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String piece = sc.nextLine();
            String[] tokens = piece.split("\\|");
            piecesInfo.put(tokens[0], new ArrayList<>());
            piecesInfo.get(tokens[0]).add(tokens[1]);
            piecesInfo.get(tokens[0]).add(1, tokens[2]);
        }

        String command = sc.nextLine();
        while(!command.equals("Stop")){
            String[] commandData = command.split("\\|");
            String commandType = commandData[0];
            String piece = commandData[1];
            switch (commandType){
                case "Add":
                    String composer = commandData[2];
                    String key = commandData[3];
                    if(!piecesInfo.containsKey(piece)){
                        piecesInfo.put(piece, new ArrayList<>());
                        piecesInfo.get(piece).add(composer);
                        piecesInfo.get(piece).add(1,key);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }else{
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    if(piecesInfo.containsKey(piece)){
                        piecesInfo.remove(piece);
                        System.out.println("Successfully removed " + piece +"!");
                    }else{
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandData[2];
                    if(piecesInfo.containsKey(piece)){
                        piecesInfo.get(piece).set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece, newKey);
                    }else{
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
            }
            command = sc.nextLine();
        }
        piecesInfo.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    
                    System.out.printf("%s -> Composer: %s, Key: %s%n",e.getKey(),e.getValue().get(0),e.getValue().get(1));
                });
    }
}
