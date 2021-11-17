package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) throws
            IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {

        Class<Reflection> reflectionClass = Reflection.class;

        Field[] declaredFields = reflectionClass.getDeclaredFields();
        List<Field> wrongFields = new ArrayList<>();

        for(Field field : declaredFields){
            if(!Modifier.isPrivate(field.getModifiers())){
                wrongFields.add(field);
            }
        }

        wrongFields.sort(Comparator.comparing(Field::getName));

        for (Field wrongField : wrongFields) {
            System.out.println(wrongField.getName() + " must be private!");
        }



        Set<Method> wrongGetters = new LinkedHashSet<>();
        Set<Method> wrongSetters = new LinkedHashSet<>();

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().contains("set") && !Modifier.isPrivate(declaredMethod.getModifiers())){
                wrongSetters.add(declaredMethod);
            }else if(declaredMethod.getName().contains("get") && !Modifier.isPublic(declaredMethod.getModifiers())){
                wrongGetters.add(declaredMethod);
            }
        }

        wrongGetters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        wrongSetters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));

    }



    public static String formatType(Class<?> type){
        return type == int.class ? "class " + type : type.toString();
    }
}


