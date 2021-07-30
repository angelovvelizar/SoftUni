package MoreExercises;

import java.util.*;

public class MobaChallenger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, TreeMap<String, Integer>> playersInfo = new TreeMap<>();

        String input = sc.nextLine();
        boolean has = false;
        while(!input.equals("Season end")){
            String[] data;
            String operand = "";
            if(input.contains("->")){
                data = input.split("\\s+->\\s+");
                String player = data[0];
                String position = data[1];
                int skill = Integer.parseInt(data[2]);
                if(!playersInfo.containsKey(player)){
                    playersInfo.put(player,new TreeMap<>());
                    playersInfo.get(player).put(position,skill);
                }else{

                    if(!playersInfo.get(player).containsKey(position)){
                        playersInfo.get(player).put(position,skill);
                    }else{
                        int currentPositionSkill = playersInfo.get(player).get(position);
                        if(currentPositionSkill < skill){
                            playersInfo.get(player).put(position,skill);
                        }
                    }
                }

            }else if(input.contains("vs")){
                data = input.split("\\s+vs\\s+");
                String player1 = data[0];
                String player2 = data[1];
                if(playersInfo.containsKey(player1) && playersInfo.containsKey(player2)){
                    //start duel
                    boolean hasCommon = false;
                    for(String s : playersInfo.get(player1).keySet()){
                        for(String s1 : playersInfo.get(player2).keySet()){
                            if(s.equals(s1)){
                                hasCommon = true;
                                break;
                            }
                        }
                    }
                    if(hasCommon){
                        if(playersInfo.get(player1).values().stream().mapToInt(i -> i).sum()
                            > playersInfo.get(player2).values().stream().mapToInt(i -> i).sum()){
                            playersInfo.remove(player2);
                        }else if(playersInfo.get(player1).values().stream().mapToInt(i -> i).sum()
                        < playersInfo.get(player2).values().stream().mapToInt(i -> i).sum()){
                            playersInfo.remove(player1);
                        }
                    }

                }

            }

            input = sc.nextLine();
        }

        playersInfo.entrySet().stream()
                .sorted((p1,p2)->Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum()))
                .forEach(e -> {
                    System.out.printf("%s: %d skill%n", e.getKey(),e.getValue().values().stream().mapToInt(i -> i).sum());

                    e.getValue().entrySet().stream()
                            .sorted((f,s) -> s.getValue() - f.getValue())
                            .forEach(position -> System.out.printf("- %s <::> %d%n",position.getKey(),position.getValue()));
                });

    }
}
