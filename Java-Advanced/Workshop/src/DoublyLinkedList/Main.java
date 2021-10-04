package DoublyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(32);
        doublyLinkedList.addFirst(13);
        doublyLinkedList.addLast(42);
        doublyLinkedList.addLast(69);

        doublyLinkedList.forEach(System.out::println);
        System.out.println();
    }
}
