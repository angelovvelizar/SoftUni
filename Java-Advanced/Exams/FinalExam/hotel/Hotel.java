package FinalExam.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;


    public Hotel(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(this.roster.size() < capacity){
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person person : roster) {
            if(person.getName().equals(name)){
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    //potential error

    public Person getPerson(String name, String hometown){
        return this.roster.stream().filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        for (Person person : roster) {
            sb.append(person.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }


}
