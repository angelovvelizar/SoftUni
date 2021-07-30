package Lab;

import java.util.*;

public class SoftUniExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, Integer> languageSubmissions = new HashMap<>();
        Map<String, Integer> userPoints = new HashMap<>();

        while(!input.equals("exam finished")){
            String[] tokens = input.split("-");
            String username = tokens[0];
            String language = tokens[1];
            if(language.equals("banned")){
                userPoints.remove(username);
                input = sc.nextLine();
                continue;
            }
            if(!languageSubmissions.containsKey(language)){
                languageSubmissions.put(language,1);
            }else{
                languageSubmissions.put(language, languageSubmissions.get(language) + 1);
            }

            int points = Integer.parseInt(tokens[2]);
            if(!userPoints.containsKey(username)) {
                userPoints.put(username, points);
            }else {
                int currentPoints = userPoints.get(username);
                if (points > currentPoints) {
                    userPoints.put(username, points);
                }
            }
            input = sc.nextLine();
        }

        System.out.println("Results:");

        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

        System.out.println("Submissions:");
        languageSubmissions.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

    }
}
