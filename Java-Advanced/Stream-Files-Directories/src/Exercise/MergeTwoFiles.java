import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstPath = Paths.get("C:\\Users\\Angelov Velizar" +
                "\\Desktop\\Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\inputOne.txt");

        List<String> linesFromFirstInput = getAllLines(firstPath);

        Path secondPath = Paths.get("C:\\Users\\Angelov Velizar\\Desktop" +
                "\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\inputTwo.txt");
        List<String> linesFromSecondInput = getAllLines(secondPath);

        PrintStream printStream = new PrintStream("merged-output.txt");

        mergeFiles(printStream,linesFromFirstInput,linesFromSecondInput);

    }

    private static void mergeFiles(PrintStream printStream, List<String> linesFromFirstInput, List<String> linesFromSecondInput) {
        printLines(printStream, linesFromFirstInput, linesFromSecondInput);

    }

    private static void printLines(PrintStream printStream, List<String> linesFromFirstInput, List<String> linesFromSecondInput) {
        for(String line : linesFromFirstInput){
            printStream.println(line);
        }

        for(String line : linesFromSecondInput){
            printStream.println(line);
        }
    }

    private static List<String> getAllLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
