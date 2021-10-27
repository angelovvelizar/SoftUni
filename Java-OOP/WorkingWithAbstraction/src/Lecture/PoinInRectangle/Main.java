package Lecture.PoinInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] coordinates = getCoordinatesAsArray(sc);

        Rectangle rectangle = new Rectangle(new Point(coordinates[0],coordinates[1]), new Point(coordinates[2], coordinates[3]));

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            int[] currentPoint = getCoordinatesAsArray(sc);
            Point point = new Point(currentPoint[0], currentPoint[1]);
            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getCoordinatesAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
