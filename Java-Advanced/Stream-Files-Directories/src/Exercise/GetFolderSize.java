import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\Angelov Velizar\\Desktop\\Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources");

        long size = 0;
        for(File file : Objects.requireNonNull(folder.listFiles())){
            size += file.length();
        }
        System.out.println(size);

    }
}

