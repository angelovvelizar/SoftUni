import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> compounds = new TreeSet<>();

        while(n-- > 0){
            String[] elements = sc.nextLine().split("\\s+");
            compounds.addAll(Arrays.asList(elements));
        }

        System.out.println(String.join(" ",compounds));
    }
}
