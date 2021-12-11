package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
    private Player player;
    private Gun gun;

    @Before
    public void setUp(){
        this.player = new Player("testPlayer",100);
        this.gun = new Gun("testGun", 50);
    }
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsIfNameIsNull(){
        this.player = new Player(null,500);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsIfNameIsEmpty(){
        this.player = new Player("",500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthThrowsIfNegative(){
        this.player = new Player("Testing",-10);
    }

    @Test
    public void testConstructorCreatesCorrectObject(){
        this.player = new Player("Testing", 60);
        Assert.assertEquals("Testing",this.player.getUsername());
        Assert.assertEquals(60,this.player.getHealth());
        Assert.assertEquals(0,this.player.getGuns().size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunThrowsIfGunIsNull(){
        this.player.addGun(null);
    }

    @Test
    public void testAddGunAddsTheGun(){
        this.player.addGun(this.gun);
        Assert.assertEquals(1, this.player.getGuns().size());
        Gun expectedGun = this.player.getGun("testGun");
        Assert.assertEquals(expectedGun,this.player.getGuns().get(0));
    }

    @Test
    public void testRemoveGunRemovesTheGun(){
        this.player.addGun(this.gun);
        Assert.assertTrue(this.player.removeGun(this.gun));
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsIfHealthIsZero(){
        this.player = new Player("testing", 0);
        this.player.takeDamage(30);
    }

    @Test
    public void testTakeDamageSetTheHealthToZeroIfKilled(){
        this.player = new Player("testing", 30);
        this.player.takeDamage(40);
        Assert.assertEquals(0,this.player.getHealth());
    }

    @Test
    public void testTakeDamageSetTheHealthToCorrectAmount(){
        this.player = new Player("testing", 30);
        this.player.takeDamage(20);
        Assert.assertEquals(10,this.player.getHealth());
    }



}
