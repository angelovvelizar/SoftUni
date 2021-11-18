package exercise.barracksWars;

import exercise.barracksWars.interfaces.Repository;
import exercise.barracksWars.interfaces.Runnable;
import exercise.barracksWars.interfaces.UnitFactory;
import exercise.barracksWars.core.Engine;
import exercise.barracksWars.core.factories.UnitFactoryImpl;
import exercise.barracksWars.data.UnitRepository;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
