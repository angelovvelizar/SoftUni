package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;
    private Cat cat;

    @Before
    public void setUp(){
        this.house = new House("testHouse",10);
        this.cat = new Cat("testCat");
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsIfNameIsNull(){
        this.house = new House(null,20);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsIfNameIsEmpty(){
        this.house = new House("  ",20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsIfCapacityIsNegative(){
        this.house = new House("test",-1);
    }

    @Test
    public void testConstructorCreatesCorrectObject(){
        Assert.assertEquals("testHouse", this.house.getName());
        Assert.assertEquals(10,this.house.getCapacity());
        Assert.assertEquals(0,this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowsIfNoCapacity(){
        this.house = new House("test",1);
        this.house.addCat(this.cat);
        this.house.addCat(new Cat("testing"));
    }

    @Test
    public void testAddMethodAddsTheCat(){
        this.house.addCat(this.cat);
        Assert.assertEquals(1,this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodThrowsIfNoSuchCat(){
        this.house.addCat(this.cat);
        this.house.removeCat("testing");
    }

    @Test
    public void testRemoveMethodRemovesTheCat(){
        this.house.addCat(this.cat);
        this.house.removeCat("testCat");
        Assert.assertEquals(0,this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsIfNoSuchCat(){
        this.house.addCat(this.cat);
        this.house.catForSale("testing");
    }

    @Test
    public void testCatForSaleReturnsCorrectCat(){
        this.house.addCat(this.cat);
        Cat expectedCat = this.house.catForSale("testCat");
        Assert.assertEquals(expectedCat,this.cat);
    }

    @Test
    public void testCatForSaleSetsHungryToFalse(){
        this.house.addCat(this.cat);
        Cat expectedCat = this.house.catForSale("testCat");
        Assert.assertFalse(expectedCat.isHungry());
    }

    @Test
    public void testStatisticsReturnCorrectOutput(){
        this.house.addCat(this.cat);
        String actualOutput = this.house.statistics();
        String expectedOutput = String.format("The cat %s is in the house %s!", this.cat.getName(), this.house.getName());
        Assert.assertEquals(expectedOutput,actualOutput);

    }



}
