package CookingSellingOpenning.Backery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if(this.employees.size() < capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":").append("\n");
        for (Employee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        return sb.toString();
    }
}
