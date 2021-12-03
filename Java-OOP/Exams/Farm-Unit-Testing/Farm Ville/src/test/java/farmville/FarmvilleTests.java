package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    private Farm testFarm;
    private Animal testAnimal;

    @Before
    public void setUp(){
        this.testFarm = new Farm("TestFarm", 10);
        this.testAnimal = new Animal("TestType", 30.00);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsIfNameIsNull(){
        testFarm = new Farm(null,30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsIfNegative(){
        this.testFarm = new Farm("test", -1);

    }

    @Test
    public void testConstructorCreatesTheCorrectObject(){
        Farm farm = new Farm("test",30);
        Assert.assertEquals(30, farm.getCapacity());
        Assert.assertEquals("test", farm.getName());
        Assert.assertEquals(0,farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsNoCapacity(){
        Farm farm = new Farm("test",1);
        farm.add(testAnimal);
        farm.add(new Animal("test1",40.00));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsSuchAnimal(){
        Farm farm = new Farm("test",10);
        farm.add(testAnimal);
        farm.add(new Animal("TestType", 45.00));
    }

    @Test
    public void testAddShouldAddTheAnimal(){
        this.testFarm.add(testAnimal);
        Assert.assertEquals(1, testFarm.getCount());
    }

    @Test
    public void testRemoveReturnsTrue(){
        this.testFarm.add(testAnimal);
        Assert.assertTrue(testFarm.remove("TestType"));
    }

    @Test
    public void testRemoveReturnsFalse(){
        this.testFarm.add(testAnimal);
        Assert.assertFalse(testFarm.remove("TestType11"));
    }


}
