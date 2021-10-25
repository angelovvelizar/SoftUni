package Exercise.Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stones = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(Arrays.stream(stones).boxed().collect(Collectors.toList()));

        String command = sc.nextLine();

        List<String> output = new ArrayList<>();
        for (Integer stone : lake) {
            output.add(String.valueOf(stone));
        }

        System.out.println(String.join(", ", output));
    }
}
