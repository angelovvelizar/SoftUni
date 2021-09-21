package Lecture;

import java.io.FileInputStream;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {



        String path = "E:\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner sc = new Scanner(inputStream);
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
            inputStream.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
