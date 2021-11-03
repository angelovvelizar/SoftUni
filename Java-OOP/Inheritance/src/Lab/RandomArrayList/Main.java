package Lab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add("42");
        randomArrayList.add("20");
        randomArrayList.add("32");
        randomArrayList.add("88");

        System.out.println(randomArrayList.getRandomElement());
    }
}
