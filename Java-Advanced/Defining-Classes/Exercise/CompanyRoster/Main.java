package Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Employee> employees = new ArrayList<>();

        while(n-- > 0){
            String[] input = sc.nextLine().split("\\s+");

            Employee employee = new Employee();

            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);

            switch (input.length){
                case 5:
                    if(input[4].contains("@")){
                        employee.setEmail(input[4]);
                    }else{
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                        employee.setEmail(input[4]);
                        employee.setAge(Integer.parseInt(input[5]));
                    break;
            }
            employees.add(employee);
        }

        List<String> departmentList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departments = new ArrayList<>();

        for(String department : departmentList){
            departments.add(new Department(department, employees.stream()
                    .filter( e -> e.getDepartment().equals(department))
                    .collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());

        Department highestAverageSalaryDepartment = departments.get(0);

        highestAverageSalaryDepartment.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", highestAverageSalaryDepartment.getName());

        for(Employee employee : highestAverageSalaryDepartment.getEmployee()){
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }

    }
}
