package Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private double averageSalary;
    private List<Employee> employee;

    public Department(String name, List<Employee> employee){
        this.name = name;
        this.employee = employee;
        this.averageSalary = employee.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

}
