package Exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator{
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

}
