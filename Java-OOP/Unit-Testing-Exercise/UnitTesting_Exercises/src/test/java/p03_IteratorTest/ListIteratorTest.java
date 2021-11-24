package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] STRINGS = {"A", "B", "C"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS);
    }

    @Test
    public void testConstructorShouldCreateCorrectObject() throws OperationNotSupportedException {
        for (int i = 0; i < STRINGS.length; i++) {
            Assert.assertEquals(STRINGS[i],listIterator.getElements().get(i));
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenTheParameterIsNull() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testHasNextReturnsTrueWhenThereIsNextElement(){
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextReturnsFalseWhenThereIsNoNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator("A");
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveReturnsTrueWhenThereIsNextElement(){
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveReturnsFalseWhenThereIsNoNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator("A");
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintMethodShouldThrowWhenThereAreNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldPrintTheElementAtCurrentIndex(){
        String element = listIterator.print();
        Assert.assertEquals("A",element);
    }




}