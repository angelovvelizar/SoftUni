package Exercise.CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int removeOperations = Integer.parseInt(sc.nextLine());

        Collection addCollection = new AddCollection();
        addItems(input, addCollection);

        Collection addRemoveCollection = new AddRemoveCollection();
        addItems(input, addRemoveCollection);

        Collection myList = new MyListImpl();
        addItems(input, myList);

        removeItems(removeOperations, addRemoveCollection);
        removeItems(removeOperations, myList);
    }

    private static void removeItems(int removeOperations, Collection collection) {
        for (int i = 0; i < removeOperations; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void addItems(String[] input, Collection collection) {
        for (String s : input) {
            System.out.print(collection.add(s) + " ");
        }
        System.out.println();
    }
}
