package Lab.Animal;

public class Cat extends Animal{
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n MEEOW", super.getName(), super.getFavouriteFood());
    }
}