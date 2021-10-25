package BombsSnakeParking.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;


    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Car car){
        if(this.data.size() < capacity){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer)
                                && c.getModel().equals(model));
    }

    public Car getLatestCar(){
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findAny().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append("\n");
        for (Car car : data) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }
}
