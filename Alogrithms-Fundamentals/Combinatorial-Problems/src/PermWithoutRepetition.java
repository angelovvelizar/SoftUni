import java.util.Scanner;

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
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(elements, index + 1);
            swap(elements, index, i);
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
