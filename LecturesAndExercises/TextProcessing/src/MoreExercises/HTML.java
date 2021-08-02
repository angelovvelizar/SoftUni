package MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String titleContent = sc.nextLine();

        System.out.println("<h1>");
        System.out.println("    " + title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("    " + titleContent);
        System.out.println("</article>");
        String comment = sc.nextLine();
        while(!comment.equals("end of comments")){
            System.out.println("<div>");
            System.out.println("    " + comment);
            System.out.println("</div>");
            comment = sc.nextLine();
        }
    }
}
