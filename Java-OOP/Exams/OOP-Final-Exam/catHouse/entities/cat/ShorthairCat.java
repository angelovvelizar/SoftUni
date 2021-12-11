package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static final int INITIAL_KILOGRAMS = 7;


    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        int newKilograms = this.getKilograms() + 1;
        this.setKilograms(newKilograms);
    }

}
