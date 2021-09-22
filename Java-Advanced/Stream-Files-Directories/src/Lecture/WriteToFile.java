package Lecture;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\PC\\OneDrive\\Работен плот\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            int nextByte = inputStream.read();
            Set<Character> punctuations = new HashSet<>((Arrays.asList(',', '.', '!', '?')));
            PrintStream printStream = new PrintStream("out.txt");

            while(nextByte != -1){
                if(!punctuations.contains((char)nextByte)){
                    printStream.print((char)nextByte);
                }
                nextByte = inputStream.read();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
