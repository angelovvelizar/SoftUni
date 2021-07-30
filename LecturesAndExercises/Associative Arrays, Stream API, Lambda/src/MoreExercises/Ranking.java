package MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstInput = sc.nextLine();
        Map<String, String> contestPasswords = new LinkedHashMap<>();

        while(!firstInput.equals("end of contests")){
            String[] data = firstInput.split(":");
            String contest = data[0];
            String password = data[1];
            contestPasswords.put(contest,password);
            firstInput = sc.nextLine();
        }

        Map<String, LinkedHashMap<String, Integer>> userContests = new TreeMap<>();
        String secondInput = sc.nextLine();
        while(!secondInput.equals("end of submissions")){
            String[] data = secondInput.split("=>");
            String contest = data[0];
            String password = data[1];
            String username = data[2];
            int points = Integer.parseInt(data[3]);
            if(contestPasswords.containsKey(contest) && contestPasswords.get(contest).equals(password)){
                if(!userContests.containsKey(username)) {
                    userContests.put(username, new LinkedHashMap<>());
                    userContests.get(username).put(contest, points);
                }else{
                    if(!userContests.get(username).containsKey(contest)){
                        userContests.get(username).put(contest,points);
                    }else{
                        userContests.get(username).put(contest,Math.max(points,userContests.get(username).get(contest)));
                        /*int currentPoints = userContests.get(username).get(contest);
                        if(points > currentPoints) {
                            userContests.get(username).put(contest, points);
                        }*/
                    }
                    //userContests.get(username).put(contest,points);
                }

            }
            secondInput = sc.nextLine();
        }
        //ForumSolution
        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : userContests.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : userContests.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking:");
        userContests.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
        ////My solution
        /*String bestCandidate = "";
        int bestPoints = 0;
        for(Map.Entry<String, Map<String, Integer>> entry : userContests.entrySet()){
            int totalPoints = 0;
            for(Map.Entry<String, Integer> userEntry : userContests.get(entry.getKey()).entrySet()){
                int points = userEntry.getValue();
                totalPoints += points;
            }
            if(totalPoints > bestPoints){
                bestPoints = totalPoints;
                bestCandidate = entry.getKey();
            }
        }
        System.out.println("Best candidate is " + bestCandidate + " with total " + bestPoints + " points.");
        System.out.println("Ranking:");

        userContests.entrySet().stream()
                .sorted(Map.Entry.<String, Map<String,Integer>>comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());

                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(user -> System.out.println("# " + user.getKey() + " -> " + user.getValue()));
                });*/
    }
}
