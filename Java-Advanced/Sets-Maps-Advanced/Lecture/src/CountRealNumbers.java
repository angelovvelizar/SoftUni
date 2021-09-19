import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] values = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> realNumbers = new LinkedHashMap<>();

        for (double value : values) {
            if(!realNumbers.containsKey(value)){
                realNumbers.put(value, 1);
            }else{
                realNumbers.put(value,realNumbers.get(value) + 1);
            }
        }

        realNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
