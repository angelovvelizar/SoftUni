package Lecture;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\PC\\OneDrive\\Работен плот\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int readBytes = inputStream.read();
            while(readBytes != - 1){
                System.out.print(Integer.toBinaryString(readBytes) + " ");
                readBytes = inputStream.read();
            }
            inputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
