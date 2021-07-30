package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while(!command.equals("stop")){
        String resource = command;
        int quantity = Integer.parseInt(sc.nextLine());
        if(!resources.containsKey(resource)){
            resources.put(resource,quantity);
        }else{
            resources.put(resource,resources.get(resource) + quantity);
        }
        command = sc.nextLine();
        }
        resources.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
