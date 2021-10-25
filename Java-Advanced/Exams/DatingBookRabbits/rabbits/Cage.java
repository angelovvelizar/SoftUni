package DatingBookRabbits.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if(this.data.size() < this.capacity){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        for (Rabbit rabbit : data) {
            if(rabbit.getName().equals(name)){
                data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species){
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : data) {
            if(rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> soldRabbits = new ArrayList<>();

        for (Rabbit rabbit : data) {
            if(rabbit.getSpecies().equals(species)){
                soldRabbits.add(rabbit);
                rabbit.setAvailable(false);
            }
        }

        return  soldRabbits;
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at ").append(this.name).append(":").append(System.lineSeparator());

        for (Rabbit rabbit : data) {
            if(rabbit.isAvailable()){
                sb.append(rabbit.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
