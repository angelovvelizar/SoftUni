package Exercise;


import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        String[] tokens = filePath.split("\\\\");
        String file = tokens[tokens.length - 1];
        String[] fileData = file.split("\\.");
        String fileName = fileData[0];
        String extension = fileData[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);

       /* int indexToSplit = file.indexOf(".");
        //T e m p l a t e . p  p  t  x
        //0 1 2 3 4 5 6 7 8 9 10 11 12
        String fileName = file.substring(0,indexToSplit);
        String fileExtension = file.substring(indexToSplit + 1);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);*/

    }
}
