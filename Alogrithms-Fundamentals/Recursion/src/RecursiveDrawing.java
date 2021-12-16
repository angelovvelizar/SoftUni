import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        drawFigure(n);

    }

    private static void drawFigure(int n) {
        if(n == 0){
            return;
        }

        drawSymbol(n, "*");

        drawFigure(n - 1);

        drawSymbol(n,"#");

    }

    private static void drawSymbol(int n, String symbol){
        for (int i = 0; i < n; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }


}
