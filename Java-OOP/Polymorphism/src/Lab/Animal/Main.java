package Lab.Animal;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Exercise.WildFarm.Food.Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());

    }
}
