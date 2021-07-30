package MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, TreeMap<String, Integer>> contestParticipantsAndPoints = new LinkedHashMap<>();
        Map<String, Integer> individualStatistic = new TreeMap<>();

        while(!input.equals("no more time")){
            String[] data = input.split("\\s+->\\s+");
            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);
            if(!contestParticipantsAndPoints.containsKey(contest)){
                contestParticipantsAndPoints.put(contest,new TreeMap<>());
                contestParticipantsAndPoints.get(contest).put(username,points);
            }else{
                if(contestParticipantsAndPoints.get(contest).containsKey(username)){
                    int currentPoints = contestParticipantsAndPoints.get(contest).get(username);
                    contestParticipantsAndPoints.get(contest).put(username, Math.max(points, currentPoints));
                }else{
                    contestParticipantsAndPoints.get(contest).put(username,points);
                }
            }

            input = sc.nextLine();
        }
        AtomicInteger num = new AtomicInteger(1);


        contestParticipantsAndPoints.entrySet()
                .forEach(e ->{
                    num.set(1);
                    System.out.printf("%s: %d participants%n",e.getKey(),e.getValue().size());

                    e.getValue().entrySet().stream()
                            .sorted((f,s) -> s.getValue() - f.getValue())
                            .forEach(entry ->{
                                System.out.printf("%d. %s <::> %d%n",num.getAndIncrement(),entry.getKey(),entry.getValue());

                            });
                });

        for(Map.Entry<String, TreeMap<String, Integer>> entry : contestParticipantsAndPoints.entrySet()) {
            for (Map.Entry<String, Integer> statistics : entry.getValue().entrySet()) {
                individualStatistic.putIfAbsent(statistics.getKey(), 0);
                individualStatistic.put(statistics.getKey(), individualStatistic.get(statistics.getKey()) + statistics.getValue());
            }
        }
        System.out.println("Individual standings:");
        num.set(1);
        individualStatistic.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
        .forEach(e -> System.out.printf("%d. %s -> %d%n",num.getAndIncrement(),e.getKey(),e.getValue()));
    }
}
