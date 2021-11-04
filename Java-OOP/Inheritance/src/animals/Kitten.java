package animals;

public class Kitten extends Cat {
    private final static String DEFAULT_KITTEN_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, DEFAULT_KITTEN_GENDER);
    }

    @Override
    public String produceSound(){
        return "Meow";
    }

    public static String getDefaultKittenGender() {
        return DEFAULT_KITTEN_GENDER;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
