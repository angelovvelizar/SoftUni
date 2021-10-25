package Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int index = 0;


    public ListyIterator(String... elements){
        this.elements = Arrays.asList(elements);
        index = 0;
    }

    public boolean hasNext(){
        return this.index < this.elements.size() - 1;
    }

    public boolean Move(){
        if(!hasNext()){
            return false;
        }
        this.index++;
        return true;
    }

    public void Print(){
        try{
            System.out.println(this.elements.get(index));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }
    }

    public void PrintAll(){
        if(elements.size() == 0){
            throw new IllegalStateException();
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                index++;
                return elements.get(index);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }
}
