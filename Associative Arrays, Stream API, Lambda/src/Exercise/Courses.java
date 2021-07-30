package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String >> courses = new LinkedHashMap<>();

        String input = sc.nextLine();
        while(!input.equals("end")){
            String[] tokens = input.split("\\s+:\\s+");
            String courseName = tokens[0];
            String studentName = tokens[1];
            if(!courses.containsKey(courseName)){
                courses.put(courseName,new ArrayList<>());
            }
            courses.get(courseName).add(studentName);
            input = sc.nextLine();
        }
        courses.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size())).forEach(e -> {
            System.out.println(e.getKey() + ": " + e.getValue().size());
            e.getValue().stream().sorted(String::compareTo)
                    .forEach(student -> System.out.println("-- " + student));
        });

    }
}
