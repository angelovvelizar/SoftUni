package Lecture;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {


        //File file = new File("input.txt");
        Path path = Paths.get("input.txt");
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);

        PrintStream printStream = new PrintStream("sorted-lines.txt");

        for (String line : lines) {
            printStream.println(line);
        }


    }
}
