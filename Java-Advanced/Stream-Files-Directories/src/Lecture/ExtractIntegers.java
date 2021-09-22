package Lecture;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("input.txt");
        PrintStream printStream = new PrintStream("integers.txt");
        Scanner sc = new Scanner(reader);

        while(sc.hasNext()){
            if(sc.hasNextInt()) {
                printStream.println(sc.nextInt());
            }
            sc.next();
        }
    }
}
