import java.util.*;
import java.util.stream.Collectors;


public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String,Double> studentsFinalGrade = new TreeMap<>();

        while(n-- > 0){
            String name = sc.nextLine();
            List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            studentsFinalGrade.put(name, average);
        }

        studentsFinalGrade.forEach((key, value) -> System.out.println(key + " is graduated with " + value));


    }
}
