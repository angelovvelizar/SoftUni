package exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        String fieldType = sc.nextLine();
        while (!fieldType.equals("HARVEST")) {
            Field[] fields = richSoilLandClass.getDeclaredFields();


            printFieldsInformation(fieldType, fields);

            fieldType = sc.nextLine();
        }

    }

    public static void printFieldsInformation(String fieldType, Field[] fields) {
        switch (fieldType) {
            case "private":
                Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers()))
                        .forEach(field -> System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName()));
                break;
            case "protected":
                Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers()))
                        .forEach(field -> System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName()));
                break;
            case "public":
                Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers()))
                        .forEach(field -> System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName()));
                break;
            case "all":
                Arrays.stream(fields)
                        .forEach(field ->
                                System.out.printf("%s %s %s%n",
                                        Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));

        }
    }

}
