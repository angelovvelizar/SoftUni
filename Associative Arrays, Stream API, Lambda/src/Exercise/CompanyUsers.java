package Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> companyAndIds = new TreeMap<>();


        String input = sc.nextLine();
        while(!input.equalsIgnoreCase("End")){
            String[] data = input.split("->");
            String companyName = data[0];
            String employeeId = data[1];
            if(!companyAndIds.containsKey(companyName)) {
                companyAndIds.put(companyName, new ArrayList<>());
            }
            if(!companyAndIds.get(companyName).contains(employeeId)) {
                companyAndIds.get(companyName).add(employeeId);
            }

            input = sc.nextLine();
        }
        for(Map.Entry<String, List<String>> entry : companyAndIds.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().forEach(id -> System.out.println("--" + id));
        }
    }
}
