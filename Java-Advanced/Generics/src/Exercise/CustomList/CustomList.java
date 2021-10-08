package Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList(){
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2) {
        T elementToSwap = this.elements.get(index1);
        this.elements.set(index1, this.elements.get(index2));
        this.elements.set(index2, elementToSwap);
    }

    public int countGreaterElements(T value){
        int counter = 0;
        for (T element : elements) {
            if(element.compareTo(value) > 0){
                counter++;
            }
        }
        return  counter;
    }

    public T getMax(){
        return Collections.max(this.elements);
    }

    public T getMin(){
        return Collections.min(this.elements);
    }

    @Override
    public Iterator<T> iterator(){
        return  new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index);

            }
        };
    }




}
