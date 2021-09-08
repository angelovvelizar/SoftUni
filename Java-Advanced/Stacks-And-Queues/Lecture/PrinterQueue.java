package Lecture;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fileName = sc.nextLine();
        ArrayDeque<String> filesToPrint = new ArrayDeque<>();

        while(!fileName.equals("print")){
            if(!fileName.equals("cancel")){
                filesToPrint.offer(fileName);
            }else{
                if(filesToPrint.isEmpty()){
                    System.out.println("Printer is on standby");
                    fileName = sc.nextLine();
                    continue;
                }else{
                    System.out.println("Canceled " + filesToPrint.poll());
                }
            }
            fileName = sc.nextLine();
        }

        for (String file : filesToPrint) {
            System.out.println(file);
        }
    }
}
