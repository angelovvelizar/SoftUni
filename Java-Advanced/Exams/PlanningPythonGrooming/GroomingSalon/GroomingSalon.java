package PlanningPythonGrooming.GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> pets;
    private int capacity;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet){
        if(pets.size() < this.capacity) {
            this.pets.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : pets) {
            if(pet.getName().equals(name)){
                pets.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : pets) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return pets.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();

        sb.append("The grooming salon has the following clients:").append("\n");
        for (Pet pet : pets) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
        return sb.toString();
    }
}
