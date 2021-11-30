package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private static final Person[] people = {new Person(1,"Ivan"),
                                            new Person(2,"Dimityr"),
                                            new Person(3,"Velizar")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowIfThereAlreadyIsSuchPersonWithSameIdInTheDatabase() throws OperationNotSupportedException {
        database.add(new Person(1,"Anastas"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowIfTheIdIsNegative() throws OperationNotSupportedException {
        database.add(new Person(-1,"Anastas"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowIfPersonParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindMethodShouldThrowIfNoSuchUsernameIsPresent() throws OperationNotSupportedException {
        database.findByUsername("Georgi");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindMethodShouldThrowIfUsernameParameterIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindMethodShouldThrowIfThereIsNoSuchPersonWithTheGivenId() throws OperationNotSupportedException {
        database.findById(4);
    }
}