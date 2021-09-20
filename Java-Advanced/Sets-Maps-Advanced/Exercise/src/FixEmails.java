import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        String name = sc.nextLine();
        while(!name.equals("stop")){
            String email = sc.nextLine().toLowerCase();
            if(!email.contains(".uk") && !email.contains(".us") && !email.contains(".com")){
                namesAndEmails.put(name,email);
            }
            name = sc.nextLine();
        }

        namesAndEmails.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
