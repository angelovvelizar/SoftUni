package Exercise.TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] givenLights = sc.nextLine().split("\\s+");

        Light[] lights = new Light[givenLights.length];

        for (int i = 0; i < lights.length; i++) {
            lights[i] = new Light(LightColor.valueOf(givenLights[i]));
        }

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Arrays.stream(lights).forEach(l -> {
                l.changeColor();
                System.out.print(l.getLightColor() + " ");
            });
            System.out.println();
        }
    }
}
