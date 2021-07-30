package Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> participants = new LinkedHashMap<>();
        names.forEach(name -> participants.put(name, 0));
        String nameRegex = "[A-Za-z]+";
        String numberRegex = "[0-9]";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern numberPattern = Pattern.compile(numberRegex);
        String input = sc.nextLine();
        while(!input.equals("end of race")){
            StringBuilder name = new StringBuilder();
            Matcher nameMatcher = namePattern.matcher(input);
            while(nameMatcher.find()){
                name.append(nameMatcher.group());
            }
            int kilometers = 0;
            Matcher numberMatcher = numberPattern.matcher(input);
            while(numberMatcher.find()){
                kilometers += Integer.parseInt(numberMatcher.group());
            }

            if(participants.containsKey(name.toString())){
                    participants.put(name.toString(),participants.get(name.toString()) + kilometers);
            }
            input = sc.nextLine();
        }

        List<String> racers = new ArrayList<>();
        participants.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3).forEach(e -> racers.add(e.getKey()));


        System.out.println("1st place: " + racers.get(0));
        System.out.println("2nd place: " + racers.get(1));
        System.out.println("3rd place: " + racers.get(2));

    }
}
