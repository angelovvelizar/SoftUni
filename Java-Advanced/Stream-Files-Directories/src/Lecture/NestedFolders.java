package Lecture;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\PC\\OneDrive\\Работен плот" +
                "\\Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);
        PrintStream printStream = new PrintStream("nested-out.txt");

        while(!files.isEmpty()){
            File innerFile = files.poll();
            printStream.println(innerFile.getName());
            for (File f : innerFile.listFiles() ) {
                if(f.isDirectory()){
                    files.offer(f);
                }else{
                    printStream.println(f.getName());
                }

            }
        }
    }
}
