package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {13,42,69,73};
    private Database database;
    private static final Integer NUMBER_TO_ADD = 3;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }



    @Test
    public void testDatabaseConstructorInitializeCorrectObject(){
        Integer[] databaseElements = database.getElements();
        assertEquals(NUMBERS.length,databaseElements.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            assertEquals(NUMBERS[i],databaseElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsWhenCapacityIsOverSixteenElements() throws OperationNotSupportedException {
        database = new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsWhenCapacityIsLessThanOneElement() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test
    public void testAddMethodShouldAddElementAtTheNextFreeCell() throws OperationNotSupportedException {
        database.add(NUMBER_TO_ADD);
        assertEquals(5,database.getElements().length);
        assertEquals(Integer.valueOf(3), database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowIfGivenElementsIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveMethodRemovesTheLastElement() throws OperationNotSupportedException {
        database.remove();
        assertEquals(3,database.getElements().length);
        assertEquals(Integer.valueOf(69),database.getElements()[2]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingFromEmptyDatabaseThrows() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }


}