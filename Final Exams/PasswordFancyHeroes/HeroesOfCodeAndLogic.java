package PasswordFancyHeroes;

import java.util.*;


public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Integer>> heroes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] heroData = sc.nextLine().split(" ");
            String heroName = heroData[0];
            int HP = Integer.parseInt(heroData[1]);
            int MP = Integer.parseInt(heroData[2]);
            heroes.putIfAbsent(heroName,new ArrayList<>());
            heroes.get(heroName).add(0,HP);
            heroes.get(heroName).add(1,MP);
        }
        String command = sc.nextLine();
        while(!command.equals("End")){
            String[] tokens = command.split(" - ");
            String commandType = tokens[0];
            String heroName = tokens[1];
            switch (commandType){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if(heroes.get(heroName).get(1) >= mpNeeded){
                        heroes.get(heroName).set(1,heroes.get(heroName).get(1) - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName,spellName,heroes.get(heroName).get(1));
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    heroes.get(heroName).set(0,heroes.get(heroName).get(0) - damage);
                    if(heroes.get(heroName).get(0) > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName,damage,attacker,heroes.get(heroName).get(0));
                    }else{
                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                        heroes.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int mpAmount = Integer.parseInt(tokens[2]);
                    int amountRecovered = Math.min(mpAmount,200 - heroes.get(heroName).get(1));
                    heroes.get(heroName).set(1,heroes.get(heroName).get(1) + amountRecovered);
                    System.out.printf("%s recharged for %d MP!%n",heroName,amountRecovered);
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(tokens[2]);
                    int amountHealed = Math.min(healAmount,100 - heroes.get(heroName).get(0));
                    heroes.get(heroName).set(0,heroes.get(heroName).get(0) + amountHealed);
                    System.out.printf("%s healed for %d HP!%n",heroName,amountHealed);
                    break;
            }
            command = sc.nextLine();
        }


        heroes.entrySet().stream()
                .sorted((f,s) -> s.getValue().get(0) - f.getValue().get(0))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("HP: " + e.getValue().get(0));
                    System.out.println("MP: " + e.getValue().get(1));
                });
    }
}
