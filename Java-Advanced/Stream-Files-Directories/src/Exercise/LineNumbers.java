import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LineNumbers {
    public static void main(String[] args) {

        try {
            //BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            Path path = Paths.get("C:\\Users\\Angelov Velizar\\Desktop\\Resources" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                    "\\Exercises Resources\\inputLineNumbers.txt");
            List<String> lines = Files.readAllLines(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            for (int i = 0; i < lines.size(); i++) {
               String format = String.format("%d. %s%n",i + 1,lines.get(i));
                bufferedWriter.write(format);
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
