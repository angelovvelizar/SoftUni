package WorldMapperPlants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String places = sc.nextLine();
        String regex = "([=]|[\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()){
            travelPoints += matcher.group("destination").length();
            destinations.add(matcher.group("destination"));
        }
        System.out.println("Destinations: " + String.join(", ",destinations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
