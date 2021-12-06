package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable {
    private static final double PRICE = 3.50;

    public Indoors(int number, int size) {
        super(number, size, PRICE);
    }
}
