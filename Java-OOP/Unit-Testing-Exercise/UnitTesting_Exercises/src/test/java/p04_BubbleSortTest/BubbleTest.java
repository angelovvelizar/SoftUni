package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    private static final int[] numbers = {5, 32, 2, 78, 34};


    @Test
    public void testBubbleSortSortsTheArrayCorrectly() {
        int[] expectedArray = {2, 5, 32, 34, 78};
        Bubble.sort(numbers);

        Assert.assertArrayEquals(expectedArray, numbers);
    }

}