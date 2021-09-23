package Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {


        //File file = new File("input.txt");
        try {
            List<String> lines = Files.readAllLines(Path.of("C:\\Users\\PC\\OneDrive\\Работен плот" +
                    "\\Exercise-Resources" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                    "\\Exercises Resources\\input.txt"));
            FileWriter fileWriter = new FileWriter("all-capitals-output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (String line : lines) {
                String upperCaseLine = line.toUpperCase();
                writer.write(upperCaseLine);
                writer.newLine();
            }
            writer.flush();
            writer.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
