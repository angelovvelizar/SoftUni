package Exercise.GenericBox;

import Exercise.GenericBox.Box;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<Double> box = new Box<>();

        while(n-- >0){
            Double currentDoule = Double.parseDouble(sc.nextLine());
            box.getElements().add(currentDoule);
        }

        /*int[] indexes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();*/
        Double value = Double.parseDouble(sc.nextLine());

        int greaterElements = box.countGreaterElements(box.getElements(), value);
        System.out.println(greaterElements);

        //System.out.println(box.toString());

    }
}
