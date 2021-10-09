package PastryFormulaCafe.cafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;



    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee){
        if(this.employees.size() < capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        boolean isRemoved = false;
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                this.employees.remove(employee);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return  null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.name).append(":").append("\n");
        for (Employee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        return  sb.toString();
    }
}
