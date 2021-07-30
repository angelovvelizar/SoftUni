package Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String starRegex = "[star]";
        Pattern starPattern = Pattern.compile(starRegex,Pattern.CASE_INSENSITIVE);
        List<String> planetsAttacked = new ArrayList<>();
        List<String> planetsDestroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String message = sc.nextLine();
            Matcher starMatcher = starPattern.matcher(message);
            int starCounter = 0;
            while (starMatcher.find()){
                starCounter++;
            }
            StringBuilder encryptedMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                encryptedMessage.append((char)(message.charAt(j) - starCounter));
            }
            String planetRegex = ".*?(?<planetName>[A-Z][a-z]+)(?:[^@\\-!:>]*):(?<population>(\\d)+)" +
                    "(?:[^@\\-!:>]*)!(?<attackType>[AD])!(?:[^@\\-!:>]*)->(?<soldierCount>\\d+)";
            Pattern planetPattern = Pattern.compile(planetRegex);
            Matcher planetMatcher = planetPattern.matcher(encryptedMessage);
            if (planetMatcher.find()) {
                if (planetMatcher.group("attackType").equals("A")) {
                    planetsAttacked.add(planetMatcher.group("planetName"));
                } else if (planetMatcher.group("attackType").equals("D")) {
                    planetsDestroyed.add(planetMatcher.group("planetName"));
                }
            }
        }
        Collections.sort(planetsAttacked);
        Collections.sort(planetsDestroyed);
        System.out.println("Attacked planets: " + planetsAttacked.size());
        if(planetsAttacked.size() > 0){
            for (String planet : planetsAttacked) {
                System.out.println("-> " + planet);
            }
        }
        System.out.println("Destroyed planets: " + planetsDestroyed.size());
        if(planetsDestroyed.size() > 0){
            for (String planet : planetsDestroyed) {
                System.out.println("-> " + planet);
            }
        }

    }
}
