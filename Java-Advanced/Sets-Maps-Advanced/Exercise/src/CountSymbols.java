import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if(!symbols.containsKey(currentSymbol)){
                symbols.put(currentSymbol,1);
            }else{
                symbols.put(currentSymbol, symbols.get(currentSymbol) + 1);
            }
        }

        symbols.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
