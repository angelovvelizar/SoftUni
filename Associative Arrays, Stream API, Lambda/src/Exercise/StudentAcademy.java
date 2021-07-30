package Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());
            if(!studentsGrades.containsKey(name)){
                studentsGrades.put(name,new ArrayList<>());
            }
            studentsGrades.get(name).add(grade);
        }
        Map<String, Double> averageGrades = new LinkedHashMap<>();

        for(Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()){
            double averageGrade = 0;
            double grades = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                grades += entry.getValue().get(i);
            }
            averageGrade = grades / entry.getValue().size();
            if(averageGrade >= 4.50) {
                averageGrades.put(entry.getKey(), averageGrade);
            }
        }
        averageGrades.entrySet().stream().
                sorted(Map.Entry.<String, Double>comparingByValue().reversed())
        .forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue()));
    }
}
