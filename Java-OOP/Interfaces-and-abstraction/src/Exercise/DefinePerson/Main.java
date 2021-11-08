package Exercise.DefinePerson;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Buyer> buyers = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            Buyer buyer;

            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            } else {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            buyers.add(buyer);
        }

        String name = sc.nextLine();
        while (!name.equals("End")) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(name)) {
                    buyer.buyFood();
                }
            }
            name = sc.nextLine();
        }

        int totalFood = 0;
        for (Buyer buyer : buyers) {
            totalFood += buyer.getFood();
        }
        System.out.println(totalFood);
    }
}
