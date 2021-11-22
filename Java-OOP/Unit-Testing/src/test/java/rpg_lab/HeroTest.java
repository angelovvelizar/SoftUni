package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroGainsExperienceWhenTargetDies(){
        Weapon weapon = Mockito.mock(Weapon.class);

        Target target = Mockito.mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(100);

        Hero hero = new Hero("The Rock",weapon);

        hero.attack(target);

        assertEquals(100,target.giveExperience());
    }

}