package exercise.barracksWars.core.factories;

import exercise.barracksWars.interfaces.Unit;
import exercise.barracksWars.interfaces.UnitFactory;
import exercise.barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class unitClass = Class.forName("exercise.barracksWars.models.units." + unitType);
		Constructor<Unit> constructor = unitClass.getConstructor();
		return constructor.newInstance();

	}
}
