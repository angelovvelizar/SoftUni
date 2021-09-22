package Lecture;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        PrintStream printStream = new PrintStream("outToBytes.txt");

        int readByte = inputStream.read();
        while(readByte != -1){
            if(readByte == 32 || readByte == 10){
                printStream.print((char) readByte);
            }else {
                printStream.print((readByte));
            }
            readByte = inputStream.read();
        }
    }
}
