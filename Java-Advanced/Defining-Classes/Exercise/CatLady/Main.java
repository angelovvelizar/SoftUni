package Exercise.CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        List<Cat> cats = new ArrayList<>();

        while(!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);
            switch (breed){
                case "Siamese":
                    Siamese siamese = new Siamese(name,parameter);
                    siamese.setBreed(breed);
                    siamese.setParameter(parameter);
                    cats.add(siamese);
                break;
                case "Cymric":
                    Cymric cymric = new Cymric(name,parameter);
                    cymric.setBreed(breed);
                    cymric.setParameter(parameter);
                    cats.add(cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name,parameter);
                    streetExtraordinaire.setBreed(breed);
                    streetExtraordinaire.setParameter(parameter);
                    cats.add(streetExtraordinaire);
                    break;
            }
            input = sc.nextLine();
        }

        String name = sc.nextLine();
        Cat catToPrint = cats.stream().filter(c -> c.getName().equals(name)).findAny().orElse(null);

        System.out.printf("%s %s %.2f", catToPrint.getBreed(),catToPrint.getName(),catToPrint.getParameter());
    }
}
