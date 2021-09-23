package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {


        try {
            FileReader reader = new FileReader("C:\\Users\\PC\\OneDrive\\Работен плот" +
                    "\\Exercise-Resources" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                    "\\Exercises Resources\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
//            int readByte = bufferedReader.read();
//            long sumOfBytes = 0;
//            while(readByte != -1){
//                sumOfBytes += readByte;
//                readByte = bufferedReader.read();
//            }
//            System.out.println(sumOfBytes);

            String txtLine = bufferedReader.readLine();
            long sum = 0;
            while(txtLine != null){
                for(char c : txtLine.toCharArray()){
                    sum += c;
                }
                txtLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println(sum);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
