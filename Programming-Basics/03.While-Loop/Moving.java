package WhileLoop;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width = Integer.parseInt(sc.nextLine());
        int length = Integer.parseInt(sc.nextLine());
        int height = Integer.parseInt(sc.nextLine());

        int cubicMeters = width*height*length;
        int boxesCubicMeters = 0;
        String text = sc.nextLine();
        while(!text.equals("Done")){
            int numberOfBoxes = Integer.parseInt(text);
            boxesCubicMeters += numberOfBoxes;
            if(boxesCubicMeters >= cubicMeters) {
                int spaceNeeded = boxesCubicMeters - cubicMeters;
                System.out.println("No more free space! You need " + spaceNeeded + " Cubic meters more.");
                break;
            //}else if(boxesCubicMeters < cubicMeters){
                //int spaceLeft = cubicMeters - boxesCubicMeters;
               // System.out.println(spaceLeft + " Cubic meters left.");
            }
            text = sc.nextLine();
        }
        if(boxesCubicMeters < cubicMeters){
            int spaceLeft = cubicMeters - boxesCubicMeters;
            System.out.println(spaceLeft + " Cubic meters left.");
        }


    }
}
