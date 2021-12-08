package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    private void setSize(int size) {
        if(size < 0){
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0 ){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        allPeople = numberOfPeople * pricePerPerson;
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;

    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);

    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);

    }

    @Override
    public double bill() {
        return this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum()
                +   beverages.stream().mapToDouble(Beverages::getPrice).sum() + allPeople;
    }

    @Override
    public void clear() {
        this.numberOfPeople = 0;
        this.isReservedTable = false;
        this.healthyFood.clear();
        this.beverages.clear();

    }

    @Override
    public String tableInformation() {
        return "Table - " + this.number + System.lineSeparator() +
                "Size - " + this.size + System.lineSeparator() +
                "Type - " + this.getClass().getSimpleName() + System.lineSeparator() +
                "All price - " + this.pricePerPerson;
    }
}
