import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Integer> materials = new LinkedHashMap<>();
        String resource = sc.nextLine();

        while(!resource.equals("stop")){
            int quantity = Integer.parseInt(sc.nextLine());
            if(!materials.containsKey(resource)){
                materials.put(resource,quantity);
            }else{
                materials.put(resource,materials.get(resource) + quantity);
            }
            resource = sc.nextLine();
        }
        materials.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
