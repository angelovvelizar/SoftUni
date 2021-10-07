package Exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>>{
    private List<T> elements;


    public Box(){
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void swap(int index1, int index2){
        T elementToSwap = this.elements.get(index1);
        this.elements.set(index1,this.elements.get(index2));
        this.elements.set(index2,elementToSwap);
    }


    public int countGreaterElements(List<T> elements, T value){
        int counter = 0;
        for (T element : elements) {
            if(element.compareTo(value) > 0){
                counter++;
            }
        }
        return  counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(),element));
        }
        return  sb.toString();
    }
}
