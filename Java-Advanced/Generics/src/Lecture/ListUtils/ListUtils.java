package Lecture.ListUtils;

import java.util.Collections;
import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list){
        isEmpty(list);
        return Collections.min(list);
    }

    private static <T extends Comparable<T>> void isEmpty(List<T> list) {
        if(list.isEmpty()){
            throw  new IllegalArgumentException("List is empty");
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        isEmpty(list);
        return Collections.max(list);
    }
}
