package Lab.BorderControl;

import Lab.BorderControl.Citizen;
import Lab.BorderControl.Identifiable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Identifiable> identifiables = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            Identifiable identifiable;
            if (tokens.length == 3) {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            } else {
                identifiable = new Robot(tokens[0], tokens[1]);
            }

            identifiables.add(identifiable);

            input = sc.nextLine();
        }

        String lastDigits = sc.nextLine();

        identifiables.forEach(o -> {
            if(o.getId().endsWith(lastDigits)){
                System.out.println(o.getId());
            }
        });
    }
}


