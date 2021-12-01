package heroRepository;

import static org.junit.Assert.*;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsIfHeroIsNull(){
        Hero hero = null;
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsIfHeroExist(){
        Hero hero = new Hero("test",10);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        heroRepository.create(new Hero("test",15));
    }

    @Test
    public void testCreateMethodAddTheHero(){
        Hero hero = new Hero("test",10);
        HeroRepository heroRepository = new HeroRepository();
        String output = heroRepository.create(hero);

        assertEquals(String.format("Successfully added hero %s with level %d", hero.getName(),hero.getLevel()), output);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowsIfHeroNameIsNull(){
        Hero hero = new Hero(null,10);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove(hero.getName());
    }

    @Test
    public void testRemoveMethodRemovesTheHero(){
        Hero hero = new Hero("test",10);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        assertTrue(heroRepository.remove("test"));
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsTheCorrectHero(){
        Hero hero = new Hero("test",10);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        Hero hero1 = new Hero("test1", 15);
        heroRepository.create(hero1);

        assertEquals(15,heroRepository.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testGetHeroReturnsTheCorrectHero(){
        Hero hero = new Hero("test",10);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(hero);
        Hero hero1 = new Hero("test1", 15);
        heroRepository.create(hero1);

        assertEquals("test1",heroRepository.getHero("test1").getName());
    }


}
