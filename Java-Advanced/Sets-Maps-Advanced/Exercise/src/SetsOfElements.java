import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int m = input[1];

        Set<Integer> firstSet = fillSet(n,sc);
        Set<Integer> secondSet = fillSet(m,sc);

        firstSet.forEach(number -> {
            if(secondSet.contains(number)){
                System.out.print(number + " ");
            }
        });

    }

    public static Set<Integer> fillSet(int numberOfElements,Scanner sc){
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < numberOfElements; i++) {
            int number = Integer.parseInt(sc.nextLine());
            set.add(number);
        }
        return set;
    }
}
