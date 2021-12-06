package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable{
    private static final double PRICE = 4.50;

    public InGarden(int number, int size) {
        super(number, size, PRICE);
    }
}
