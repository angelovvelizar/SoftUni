package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthyFood;
    private BeverageRepository<Beverages> beverages;
    private TableRepository<Table> tables;
    private double totalMoney;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
    this.healthyFood = healthFoodRepository;
    this.beverages = beverageRepository;
    this.tables = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food;
        if(type.equals("Salad")){
            food = new Salad(name,price);
        }else{
            food = new VeganBiscuits(name,price);
        }

        if(healthyFood.foodByName(name) != null){
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        healthyFood.add(food);

        return String.format(FOOD_ADDED,name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage;
        if(type.equals("Fresh")){
            beverage = new Fresh(name,counter,brand);
        }else{
            beverage = new Smoothie(name,counter,brand);
        }
        if(beverages.beverageByName(name,brand) != null){
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST,name));
        }

        beverages.add(beverage);
        return String.format(BEVERAGE_ADDED,type,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:
        Table table;
        if(type.equals("Indoors")){
            table = new Indoors(tableNumber,capacity);
        }else{
            table = new InGarden(tableNumber,capacity);
        }

        if(tables.byNumber(tableNumber) != null){
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED,tableNumber));
        }

        tables.add(table);
        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        List<Table> tables = this.tables.getAllEntities()
                .stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .collect(Collectors.toList());

        if(tables.size() == 0){
            return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        }

        Table freeTable = tables.get(0);
        freeTable.reserve(numberOfPeople);

        return String.format(TABLE_RESERVED,freeTable.getTableNumber(),numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tables.byNumber(tableNumber);
        if(table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        HealthyFood food = healthyFood.foodByName(healthyFoodName);
        if(food == null){
            return String.format(NONE_EXISTENT_FOOD,healthyFoodName);
        }

        table.orderHealthy(food);
        return String.format(FOOD_ORDER_SUCCESSFUL,healthyFoodName,tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tables.byNumber(tableNumber);
        if(table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        Beverages beverage = beverages.beverageByName(name,brand);
        if(beverage == null){
            return String.format(NON_EXISTENT_DRINK,name,brand);
        }

        table.orderBeverages(beverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL,name,tableNumber);

    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tables.byNumber(tableNumber);
        double bill = table.bill();
        totalMoney += bill;
        table.clear();

        return String.format(BILL,tableNumber,bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY,totalMoney);
    }
}
