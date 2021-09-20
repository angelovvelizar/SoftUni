import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentsData = new TreeMap<>();


        while(n-- > 0){
            String studentInfo = sc.nextLine();
            String name = studentInfo.split(" ")[0];
            double grade = Double.parseDouble(studentInfo.split(" ")[1]);

            if(!studentsData.containsKey(name)){
                studentsData.put(name, new ArrayList<>());
            }
            studentsData.get(name).add(grade);

        }

        studentsData.forEach((key, value) -> {
            double averageGrade = value.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.print(key + " -> ");
            value.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", averageGrade);
        });

    }
}
