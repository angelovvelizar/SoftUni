import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Angelov Velizar" +
                "\\Desktop\\Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\words.txt"));

        Map<String, Integer> wordsCount = new TreeMap<>();

        String line = bufferedReader.readLine();

        List<String> lines = getLines(bufferedReader, line);
        Set<String> words = getWordsInFirstFile(lines);

        Path path = Paths.get("C:\\Users\\Angelov Velizar\\Desktop\\Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\text.txt");

        List<String> linesFromTextFile = Files.readAllLines(path);
        for(String lineInText : linesFromTextFile){
            for(String word : lineInText.split("\\b[ ]|[,][ ]\\b")){
                word = word.toLowerCase();
                if(words.contains(word)){
                    if(!wordsCount.containsKey(word)){
                        wordsCount.put(word,1);
                    }else{
                        wordsCount.put(word,wordsCount.get(word) + 1);
                    }
                }
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("results.txt"));

        wordsCount.forEach((key, value) -> {
            try {
                bufferedWriter.write(key + " - " + value + "\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    private static Set<String> getWordsInFirstFile(List<String> lines) {
        Set<String> words = new HashSet<>();

        for(String l : lines){
            words.addAll(Arrays.asList(l.split(" ")));
        }
        return words;
    }


    private static List<String> getLines(BufferedReader bufferedReader, String line) throws IOException {
        List<String> lines = new ArrayList<>();
        while(line != null){
            lines.add(line.toLowerCase());
            line = bufferedReader.readLine();
        }
        return lines;
    }
}
