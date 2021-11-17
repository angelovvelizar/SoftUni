package exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        Scanner sc = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        BlackBoxInt innerValue = createInstance(blackBoxIntClass);

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Field currentValue = blackBoxIntClass.getDeclaredField("innerValue");
            currentValue.setAccessible(true);

            switch (command) {
                case "add":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "add");
                    break;
                case "subtract":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "subtract");
                    break;
                case "multiply":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "multiply");
                    break;
                case "divide":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "divide");
                    break;
                case "leftShift":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "leftShift");
                    break;
                case "rightShift":
                    printMethodResult(blackBoxIntClass, innerValue, value, currentValue, "rightShift");
                    break;
            }


            input = sc.nextLine();
        }
    }

    private static BlackBoxInt createInstance(Class<BlackBoxInt> blackBoxIntClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    private static void printMethodResult(Class<BlackBoxInt> blackBoxIntClass, BlackBoxInt innerValue, int value, Field currentValue, String methodName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        invokeMethod(blackBoxIntClass, innerValue, value, methodName);
        System.out.println(currentValue.getInt(innerValue));
    }

    private static void invokeMethod(Class<BlackBoxInt> blackBoxIntClass, BlackBoxInt innerValue, int value, String methodName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method;
        method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(innerValue, value);
    }
}
