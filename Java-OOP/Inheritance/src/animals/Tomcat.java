package animals;

public class Tomcat extends Cat {
    private final static String DEFAULT_TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, DEFAULT_TOMCAT_GENDER);
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }

    public static String getDefaultTomcatGender() {
        return DEFAULT_TOMCAT_GENDER;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
