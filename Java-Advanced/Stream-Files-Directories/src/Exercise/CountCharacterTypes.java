import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File file = new File("input.txt");
        Path path = Paths.get("input.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            for (String line : lines) {
                for (char symbol : line.toCharArray()) {
                    switch (symbol) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            vowelsCount++;
                            break;
                        case '!':
                        case '.':
                        case ',':
                        case '?':
                            punctuationCount++;
                            break;
                        default:
                            if(symbol == ' '){
                                continue;
                            }
                            consonantsCount++;
                            break;
                    }
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write("Vowels: " + vowelsCount + "\n");
            bufferedWriter.write("Consonants: " + consonantsCount + "\n");
            bufferedWriter.write("Punctuation: " + punctuationCount + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
