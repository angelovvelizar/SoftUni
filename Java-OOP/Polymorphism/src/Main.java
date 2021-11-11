import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String animalInfo = sc.nextLine();
        while(!animalInfo.equals("End")){
            String foodInfo = sc.nextLine();

            String[] animalTokens = animalInfo.split("\\s+");
            Animal animal = createAnimal(animalTokens);

            String[] foodTokens = foodInfo.split("\\s+");
            Food food = createFood(foodTokens);

            animal.makeSound();
            try{
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            System.out.println(animal.toString());


            animalInfo = sc.nextLine();
        }
    }

    private static Food createFood(String[] foodTokens) {
        if(foodTokens[0].equals("Vegetable")){
            return new Vegetable(Integer.parseInt(foodTokens[1]));
        }

        return new Meat(Integer.parseInt(foodTokens[1]));
    }

    private static Animal createAnimal(String[] animalTokens) {
        switch (animalTokens[0]){
            case "Cat":
                return new Cat(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3],animalTokens[4]);
            case "Tiger":
                return new Tiger(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Zebra":
                return new Zebra(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3]);
            case "Mouse":
                return new Mouse(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3]);
            default:
                return null;
        }
    }
}
