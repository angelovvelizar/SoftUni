package Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademyNewTry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,Double> studentGrades = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());
            if(!studentGrades.containsKey(name)){
                studentGrades.put(name,grade);
                counts.put(name,1);
            }else{
                studentGrades.put(name, studentGrades.get(name) + grade);
                counts.put(name, counts.get(name) + 1);
            }
        }
        Map<String, Double> finalGrades = new HashMap<>();
        for(Map.Entry<String, Double> entry : studentGrades.entrySet()){
            double averageGrade = entry.getValue() / counts.get(entry.getKey());
            if(averageGrade >= 4.50){
                finalGrades.put(entry.getKey(), averageGrade);
            }
        }
        finalGrades.entrySet().stream().
                sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue()));
    }
}
