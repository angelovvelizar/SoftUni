package Exercise.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> lake;

    public Lake(List<Integer> stones) {
        this.lake = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean isFinishedFirsRound = false;


        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;
            if (index >= lake.size() && !isFinishedFirsRound) {
                index = 1;
                isFinishedFirsRound = true;
            }
            return lake.get(currentIndex);
        }
    }
}
