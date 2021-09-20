import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        String input = sc.nextLine();
        while(!input.equals("JOKER")){
            String name = input.split(":")[0];
            String[] cards = input.split(":")[1].split(", ");
            if(!playerCards.containsKey(name)){
                playerCards.put(name,new HashSet<>());
            }
            for (String card : cards) {
                playerCards.get(name).add(card);
            }

            input = sc.nextLine();
        }

        playerCards.entrySet().stream()
                .forEach(e -> {
                    AtomicInteger totalPoints = new AtomicInteger();
                    e.getValue().forEach(card -> {
                        char power = card.charAt(0);
                        switch (power){
                            case 'J':
                                power = 11;
                                break;
                            case 'Q':
                                power = 12;
                                break;
                            case 'K':
                                power = 13;
                                break;
                            case 'A':
                                power = 14;
                                break;
                        }
                        char type = card.charAt(1);
                        switch (type){
                            case 'C':
                                totalPoints.set(power);
                                break;
                            case 'D':
                                totalPoints.set(power * 2);
                                break;
                            case 'H':
                                totalPoints.set(power * 3);
                                break;
                            case 'S':
                                totalPoints.set(power * 4);
                                break;
                        }
                    });
                });
    }
}
