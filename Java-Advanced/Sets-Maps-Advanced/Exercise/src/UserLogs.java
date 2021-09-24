import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input = sc.nextLine();
        while(!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String IP = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            if(!users.containsKey(username)){
                users.put(username,new LinkedHashMap<>());
                users.get(username).put(IP, 1);
            }else{
                LinkedHashMap<String, Integer> ips = users.get(username);
                if(!ips.containsKey(IP)){
                    ips.put(IP,1);
                }else{
                    ips.put(IP, ips.get(IP) + 1);
                }
            }

            input = sc.nextLine();
        }

        users.forEach((key, value) -> {
            System.out.println(key + ":");

            int counter = 0;
            for (Map.Entry<String, Integer> ip : value.entrySet()) {
                if (counter == value.size() - 1) {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ".");
                } else {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ", ");
                }
                counter++;
            }
            System.out.println();
        });
    }
}
