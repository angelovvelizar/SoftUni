package onlineShop.models.products.computers;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.contains(component)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT);
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty() ||
                this.components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPONENT);
        }

        Component componentToRemove = this.components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .get();

        this.components.remove(componentToRemove);
        return componentToRemove;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if(this.peripherals.contains(peripheral)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL);
        }

        this.peripherals.add(peripheral);

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty() ||
                this.peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(NOT_EXISTING_PERIPHERAL);
        }

        Peripheral peripheralToRemove = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .get();

        this.peripherals.remove(peripheralToRemove);
        return peripheralToRemove;
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }

        return super.getOverallPerformance() + this.components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0.0);
    }

    @Override
    public double getPrice() {
        double componentsPrice = this.components.stream().mapToDouble(Component::getPrice).sum();
        double peripheralsPrice = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return super.getPrice() + componentsPrice + peripheralsPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append(String.format(" " + OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size()));
        builder.append(System.lineSeparator());
        for (Component component : components) {
            builder.append("  ").append(component.toString())
                    .append(System.lineSeparator());
        }

        builder.append(String.format(" " + OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                this.peripherals.size(), peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0)));

        builder.append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            builder.append("  ").append(peripheral.toString())
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();

    }
}
