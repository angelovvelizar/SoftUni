package WhileLoop.Exercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = Integer.parseInt(sc.nextLine());
        int length = Integer.parseInt(sc.nextLine());

        int piecesMax = width * length;
        int totalPieces = 0;
        int piecesTaken = width * length;
        while(totalPieces < piecesMax){
            String input = sc.nextLine();
            if(input.equals("STOP")){
                break;
            }
            int currentTaking = Integer.parseInt(input);
            totalPieces += currentTaking;
            piecesTaken -= currentTaking;


        }
        if(piecesTaken <= 0){
            System.out.printf("No more cake left! You need %d pieces more.",totalPieces - width*length);
        }else{
            System.out.printf("%d pieces are left.", width*length - totalPieces);
        }
    }
}
