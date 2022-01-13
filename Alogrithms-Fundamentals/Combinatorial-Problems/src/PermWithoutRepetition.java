import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PermWithoutRepetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] elements = sc.nextLine().split("\\s+");


        permute(elements, 0);
    }

    private static void permute(String[] elements, int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permute(elements, index + 1);
        Set<String> used = new HashSet<>();
        used.add(elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if(!used.contains(elements[i])) {
                swap(elements, index, i);
                permute(elements, index + 1);
                swap(elements, index, i);
                used.add(elements[i]);
            }
        }

    }

    private static void swap(String[] elements, int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
