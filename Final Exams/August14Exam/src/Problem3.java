import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> peopleData = new TreeMap<>();
        //health is on index 0 and energy is on index 1 in the list
        String command = sc.nextLine();
        while(!command.equals("Results")){
            String[] tokens = command.split(":");
            String commandType = tokens[0];
            switch (commandType){
                case "Add":
                    String personName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);

                    if(!peopleData.containsKey(personName)){
                        peopleData.put(personName, new ArrayList<>());
                        peopleData.get(personName).add(0,health);
                        peopleData.get(personName).add(1,energy);
                    }else{
                        peopleData.get(personName).set(0,peopleData.get(personName).get(0) + health);
                    }
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    if(peopleData.containsKey(attackerName) && peopleData.containsKey(defenderName)){
                        peopleData.get(defenderName).set(0,peopleData.get(defenderName).get(0) - damage);
                        List<Integer> attacker = peopleData.get(attackerName);
                        attacker.set(1, attacker.get(1) - 1);
                        if(peopleData.get(defenderName).get(0) <= 0){
                            peopleData.remove(defenderName);
                            System.out.println(defenderName + " was disqualified!") ;
                        }
                        if(attacker.get(1) <= 0){
                            peopleData.remove(attackerName);
                            System.out.println(attackerName + " was disqualified!");
                        }
                    }
                    break;
                case "Delete":
                    String username = tokens[1];
                    if(username.equals("All")){
                        peopleData.clear();
                    }
                    peopleData.remove(username);
                    break;
            }

            command = sc.nextLine();
        }

        System.out.println("People count: " + peopleData.size());

        peopleData.entrySet().stream()
                .sorted((f,s) -> s.getValue().get(0) - f.getValue().get(0))
                .forEach(e -> {
                    System.out.printf("%s - %d - %d%n", e.getKey(),e.getValue().get(0),e.getValue().get(1));
                });

    }
}
