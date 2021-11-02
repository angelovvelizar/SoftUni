package Exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] peopleInfo = splitBySemiColumn(sc.nextLine(), ";");
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();


        getPeople(peopleInfo, people);

        String[] productsInfo = splitBySemiColumn(sc.nextLine(), ";");

        getProducts(products, productsInfo);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String personName = splitBySemiColumn(command, "\\s+")[0];
            String productName = splitBySemiColumn(command, "\\s+")[1];

            boughtTheProduct(people, products, personName, productName);

            command = sc.nextLine();
        }

        printInfo(people);
    }

    private static void printInfo(List<Person> people) {
        for (Person person : people) {
            if(person.getProducts().isEmpty()){
                System.out.println(person.getName() + " - " + "Nothing bought");
                continue;
            }
            List<Product> currentPersonProducts = person.getProducts();

            StringBuilder productsOutput = new StringBuilder();
            for (int i = 0; i < currentPersonProducts.size(); i++) {
                if(i == currentPersonProducts.size() - 1){
                    productsOutput.append(currentPersonProducts.get(i).getName());
                }else{
                    productsOutput.append(currentPersonProducts.get(i).getName()).append(", ");
                }
            }

            System.out.println(person.getName() + " - " + productsOutput.toString());
        }
    }

    private static String[] splitBySemiColumn(String s, String s2) {
        return s.split(s2);
    }

    private static void getPeople(String[] peopleInfo, List<Person> people) {
        for (String person : peopleInfo) {
            String personName = splitBySemiColumn(person, "=")[0];
            double money = Double.parseDouble(splitBySemiColumn(person, "=")[1]);

            try {
                Person p = new Person(personName, money);
                people.add(p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getProducts(List<Product> products, String[] productsInfo) {
        for (String product : productsInfo) {
            String productName = splitBySemiColumn(product, "=")[0];
            double cost = Double.parseDouble(splitBySemiColumn(product, "=")[1]);

            try {
                Product p = new Product(productName, cost);
                products.add(p);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void boughtTheProduct(List<Person> people, List<Product> products, String personName, String productName) {
        for (Person person : people) {
            if (person.getName().equals(personName)) {
                for (Product product : products) {
                    if (product.getName().equals(productName)) {
                        person.buyProduct(product);
                    }
                }
            }
        }
    }
}
