import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> information = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            information.putIfAbsent(continent, new LinkedHashMap<>());

            if (!information.get(continent).containsKey(country)) {
                information.get(continent).put(country, new ArrayList<>());

            }
            information.get(continent).get(country).add(city);

        }

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : information.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, ArrayList<String>> country : entry.getValue().entrySet()) {
                System.out.println(country.getKey() + " -> " + String.join(", ", country.getValue()));
            }

        }
    }
}
