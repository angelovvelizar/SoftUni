package ForLoop;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if(number < 200){
                p1++;
            }else if(number <= 399){
                p2++;
            }else if(number <= 599){
                p3++;
            }else if(number <=799){
                p4++;
            }else if(number >= 800){
                p5++;
            }
        }
        double percentP1 = p1 / n * 100;
        double percentP2 = p2 / n * 100;
        double percentP3 = p3 / n * 100;
        double percentP4 = p4 / n * 100;
        double percentP5 = p5 / n * 100;

        System.out.printf("%.2f%%%n",percentP1);
        System.out.printf("%.2f%%%n",percentP2);
        System.out.printf("%.2f%%%n",percentP3);
        System.out.printf("%.2f%%%n",percentP4);
        System.out.printf("%.2f%%%n",percentP5);
    }
}
