package FirstStepsInCoding.ExerciseFirstSteps;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = Integer.parseInt((sc.nextLine()));
        int confectionerNumber = Integer.parseInt((sc.nextLine()));
        int cakesByOne = Integer.parseInt((sc.nextLine()));
        int goffByOne = Integer.parseInt((sc.nextLine()));
        int pancakeByOne = Integer.parseInt((sc.nextLine()));
        double totalSum = (((cakesByOne * 45) + (goffByOne * 5.80) + (pancakeByOne * 3.20)) * confectionerNumber) * days;
        double finalSum = totalSum - (totalSum * 1/8.0);
        System.out.printf("%.2f", finalSum);
    }
}
