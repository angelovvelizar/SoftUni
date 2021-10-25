package Exercise.StackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer> {
    private ArrayDeque<Integer> stack;

    public Stack(int... elements) {
        if(elements.length == 0){
            stack = new ArrayDeque<>();
        }else {
            stack = new ArrayDeque<>();
            Arrays.stream(elements).forEach(stack::push);
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (Integer integer : stack) {
            action.accept(integer);
        }
    }

    public int Pop() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("No elements");
        }

        return this.stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return stack.iterator();

    }
}
