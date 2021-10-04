package DoublyLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private static class ListNode{
        private int element;
        private ListNode previous;
        private ListNode next;

        private ListNode(int element){
            this.element = element;
        }
    }
    private ListNode head;
    private ListNode tail;
    private int size;


    public void addFirst(int element){
        ListNode newHead = new ListNode(element);
        if(this.size == 0){
            this.head = this.tail = newHead;
        }else{
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(int element){
        ListNode newTail = new ListNode(element);

        if(this.size == 0){
            this.tail = this.head = newTail;
        }else{
            this.tail.next = newTail;
            newTail.previous = this.tail;
            this.tail = newTail;
        }

        this.size++;
    }

    public int getInt(int index){
        ensureIndex(index);
        if(index <= this.size / 2){
            ListNode firstNode = this.head;

            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.element;
        }else{
            ListNode lastNote = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                lastNote = lastNote.previous;
            }
            return  lastNote.element;
        }


    }

    public int removeFirst(){
        checkSize();
        int element = getInt(0);
        this.head = head.next;

        if(this.head == null){
            this.tail = null;
        }else{
            this.head.previous = null;
        }

        this.size--;
        return element;

    }

    public int removeLast(){
        checkSize();
        int element = getInt(this.size - 1);
        this.tail = tail.previous;

        if(this.tail == null){
            this.head = null;
        }else{
            this.tail.next = null;
        }

        this.size--;
        return  element;
    }

    public void forEach(Consumer<Integer> consumer){
        ListNode currentNode = this.head;
        while (currentNode != null){
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;
        ListNode currentNode = this.head;

        while (currentNode != null){
            array[counter++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return  array;
    }


    private void checkSize() {
        if(this.size == 0){
            throw new NoSuchElementException("The list is empty.");
        }
    }

    private void ensureIndex(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
