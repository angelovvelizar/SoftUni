package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftuniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> nameAndPlate = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandData = sc.nextLine().split("\\s+");
            String username = commandData[1];
            if(commandData.length == 3){
                if(nameAndPlate.containsKey(username)){
                    System.out.println("ERROR: already registered with plate number " + nameAndPlate.get(username));
                }else{
                    String plate = commandData[2];
                    nameAndPlate.put(username,plate);
                    System.out.println(username + " registered " + nameAndPlate.get(username) + " successfully");
                }
            }else{
                if(!nameAndPlate.containsKey(username)){
                    System.out.println("ERROR: user " + username + " not found");
                }else{
                    System.out.println(username + " unregistered successfully");
                    nameAndPlate.remove(username);
                }
            }
        }
        nameAndPlate.forEach((k,v) -> System.out.println(k + " => " + v));
    }
}
