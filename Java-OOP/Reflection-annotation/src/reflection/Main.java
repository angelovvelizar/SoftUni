package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<Reflection> reflectionClass = Reflection.class;

        Set<Method> getters = new LinkedHashSet<>();
        Set<Method> setters = new LinkedHashSet<>();

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().contains("set")){
                setters.add(declaredMethod);
            }else if(declaredMethod.getName().contains("get")){
                getters.add(declaredMethod);
            }
        }

        getters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s will return %s%n", g.getName(), formatType(g.getReturnType())));

        setters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s and will set field of %s%n", s.getName(), formatType(s.getParameterTypes()[0])));

    }

    public static String formatType(Class<?> type){
        return type == int.class ? "class " + type : type.toString();
    }
}
