package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;


    @Before
    public void setUp(){
        this.computerManager = new ComputerManager();
        this.computer = new Computer("testManufacturer", "testModel", 10.00);
    }

    @Test
    public void testConstructorCreatesCorrectObject(){
        Assert.assertEquals(0,this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodShouldThrowIfVariableIsNull(){
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodShouldThrowIfSuchComputerExists(){
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(new Computer("testManufacturer", "testModel", 30));
    }

    @Test
    public void testAddMethodAddsCorrectly(){
        this.computerManager.addComputer(computer);
        Assert.assertEquals(1, this.computerManager.getCount());
        Assert.assertEquals(this.computerManager.getComputers().get(0), this.computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsIfManufacturerIsNull(){
        this.computerManager.addComputer(computer);
        this.computerManager.getComputer(null, "testModel");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsIfModelIsNull(){
        this.computerManager.addComputer(computer);
        this.computerManager.getComputer("testManufacturer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsIfNoSuchComputer(){
        this.computerManager.addComputer(computer);
        this.computerManager.getComputer("test", "test");
    }

    @Test
    public void testGetMethodReturnsCorrectComputer(){
        this.computerManager.addComputer(computer);
        Computer expectedComputer = this.computerManager.getComputer("testManufacturer", "testModel");
        Assert.assertEquals(expectedComputer,this.computer);
    }

    @Test
    public void testRemoveMethodRemovesCorrectComputer(){
        this.computerManager.addComputer(computer);
        Computer expectedComputer = this.computerManager.removeComputer("testManufacturer", "testModel");
        Assert.assertEquals(0, this.computerManager.getCount());
        Assert.assertEquals(expectedComputer,computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersThrowsIfManufacturerIsNull(){
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersReturnCorrectComputersList(){
        Computer testComputer = new Computer("testManufacturer", "testing", 25);
        List<Computer> expectedComputers = new ArrayList<>();
        expectedComputers.add(computer);
        expectedComputers.add(testComputer);

        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(testComputer);

        Assert.assertEquals(expectedComputers,this.computerManager.getComputersByManufacturer("testManufacturer"));


    }


}