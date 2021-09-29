package Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers =Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> dsd = (x, y) -> {
            if(x % 2 != 0 && y % 2 == 0){
                return 1;
            }
            if(x % 2 == 0 && y % 2 == 0){
                if(x > y){
                    return 1;
                }else{
                    return  -1;
                }
            }
            if(x % 2 != 0){
                if(x > y){
                    return 1;
                }else{
                    return -1;
                }
            }
            return -1;
        };

        numbers.stream().sorted(dsd).forEach(x -> System.out.print(x + " "));

    }
}
