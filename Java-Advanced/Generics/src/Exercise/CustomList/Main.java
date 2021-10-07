package Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        String command = sc.nextLine();

        while(!command.equals("END")){
            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];
            switch (commandType){
                case "Add":
                    String elementToAdd = tokens[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementToCheck = tokens[1];
                    System.out.println(customList.contains(elementToCheck));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    customList.swap(index1,index2);
                    break;
                case "Greater":
                    String element = tokens[1];
                    System.out.println(customList.countGreaterElements(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.getElements()
                            .forEach(System.out::println);
                    break;
            }
            command = sc.nextLine();
        }
    }
}
