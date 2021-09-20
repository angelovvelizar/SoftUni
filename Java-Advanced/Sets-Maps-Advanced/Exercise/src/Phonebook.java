import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> phonebook = new HashMap<>();


        String input = sc.nextLine();
        while(!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name,number);
            input = sc.nextLine();
        }

        String nameToSearch = sc.nextLine();
        while(!nameToSearch.equals("stop")){
            if(phonebook.containsKey(nameToSearch)){
                System.out.println(nameToSearch + " -> " + phonebook.get(nameToSearch));
            }else{
                System.out.println("Contact " + nameToSearch + " does not exist.");
            }
            nameToSearch = sc.nextLine();
        }
    }
}
