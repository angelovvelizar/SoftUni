package Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, List<String>> forceSideUsers = new TreeMap<>();

        while (!input.equals("Lumpawaroo")) {
            String[] data;
            String operand = "";
            if (input.contains("|")) {
                data = input.split("\\s+\\|\\s+");
                operand = "|";
            } else {
                data = input.split("\\s+->\\s+");
                operand = "->";
            }
            if (operand.equals("|")) {
                String forceSide = data[0];
                String forceUser = data[1];
                if (!forceSideUsers.containsKey(forceSide)) {
                    forceSideUsers.put(forceSide, new ArrayList<>());
                    forceSideUsers.get(forceSide).add(forceUser);
                } else {
                    if (!forceSideUsers.get(forceSide).contains(forceUser)) {
                        forceSideUsers.get(forceSide).add(forceUser);
                    }
                }
            } else if (operand.equals("->")) {
                String forceUser = data[0];
                String forceSide = data[1];
                if (forceUserExists(forceSideUsers, forceUser)) {
                    if (!forceSideUsers.containsKey(forceSide)) {
                        forceSideUsers.put(forceSide, new ArrayList<>());
                    } else {
                        for (Map.Entry<String, List<String>> entry : forceSideUsers.entrySet()) {
                            if (entry.getValue().contains(forceUser)) {
                                entry.getValue().remove(forceUser);
                                break;
                            }
                        }
                    }
                } else {
                    if (!forceSideUsers.containsKey(forceSide)) {
                        forceSideUsers.put(forceSide, new ArrayList<>());
                    }
                }
                forceSideUsers.get(forceSide).add(forceUser);
                System.out.println(forceUser + " joins the " + forceSide + " side!");
            }

            input = sc.nextLine();
        }
        forceSideUsers.entrySet().stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(side -> {
                    System.out.printf("Side: %s, Members: %d%n", side.getKey(), side.getValue().size());

                    side.getValue().stream()
                    .sorted(String::compareTo).
                forEach(person -> System.out.printf("! %s%n", person));
                });
    }

    private static boolean forceUserExists(Map<String, List<String>> forceSideUsers, String forceUser) {
        boolean userExists = false;
        for (Map.Entry<String, List<String>> entry : forceSideUsers.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().contains(forceUser)) {
                    userExists = true;
                    break;
                }
            }
        }
        return userExists;
    }
}
