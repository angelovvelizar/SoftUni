package MoreExercises;



import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Integer>> heroesHPAndMM = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split("\\s+");
            String name = data[0];
            int hitPoints = Integer.parseInt(data[1]);
            int manaPoints = Integer.parseInt(data[2]);
            heroesHPAndMM.put(name,new ArrayList<>());
            heroesHPAndMM.get(name).add(0,hitPoints);
            heroesHPAndMM.get(name).add(1,manaPoints);
        }

        String command = sc.nextLine();
        while(!command.equals("End")){
            String[] commandData = command.split("\\s+-\\s+");
            String commandType = commandData[0];
            String heroName = commandData[1];
            switch (commandType){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commandData[2]);
                    String spellName = commandData[3];
                    if(heroesHPAndMM.get(heroName).get(1) >= mpNeeded){
                        heroesHPAndMM.get(heroName).set(1,heroesHPAndMM.get(heroName).get(1) - mpNeeded);
                        int manaLeft = heroesHPAndMM.get(heroName).get(1);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName, spellName,manaLeft);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];
                    heroesHPAndMM.get(heroName).set(0,heroesHPAndMM.get(heroName).get(0) - damage);
                    int hpLeft = heroesHPAndMM.get(heroName).get(0);
                    if(hpLeft > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",heroName,damage,attacker,hpLeft);
                    }else{
                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                        heroesHPAndMM.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int mpToRecharge = Integer.parseInt(commandData[2]);
                    int mpRecharged = Math.min(mpToRecharge,200 - heroesHPAndMM.get(heroName).get(1));
                    System.out.printf("%s recharged for %d MP!%n",heroName,mpRecharged);
                    int currentMP = heroesHPAndMM.get(heroName).get(1) + mpRecharged;
                    heroesHPAndMM.get(heroName).set(1,currentMP);
                    break;
                case "Heal":
                    int amount = Integer.parseInt(commandData[2]);
                    int hpRecharged = Math.min(100 - heroesHPAndMM.get(heroName).get(0), amount);
                    System.out.printf("%s healed for %d HP!%n",heroName,hpRecharged);
                    int currentHP = heroesHPAndMM.get(heroName).get(0) + hpRecharged;
                    heroesHPAndMM.get(heroName).set(0, currentHP);
                    break;
            }
            command = sc.nextLine();
        }
        heroesHPAndMM.entrySet().stream()
                .sorted((f,s) -> s.getValue().get(0) - f.getValue().get(0))
        .forEach(e -> {

            System.out.printf("%s%n",e.getKey());
            System.out.printf("HP: %d%n",e.getValue().get(0));
            System.out.printf("MP: %d%n",e.getValue().get(1));
        });
    }
}
