package WhileLoop.Exercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*String favouriteBook = sc.nextLine();
        String book = sc.nextLine();
        int booksChecked = 0;

        while(!favouriteBook.equals(book)){
            book = sc.nextLine();
            booksChecked++;
            if(favouriteBook.equals(book)){
                System.out.println("You checked " + (booksChecked) + " books and found it.");
                break;
            }
            if(book.equals("No More Books")){
                break;
            }
        }
        if(!favouriteBook.equals(book)){
            System.out.println("The book you search is not here!");
            System.out.println("You checked " + booksChecked + " books.");
        }
        */

        String favouriteBook = sc.nextLine();
        int booksChecked = 0;
        boolean isFound = false;

        while(isFound == false){
            String book = sc.nextLine();
            if(book.equals(favouriteBook)){
                System.out.println("You checked " + (booksChecked) + " books and found it.");
                isFound = true;
                break;
            }
            if(book.equals("No More Books")){
                break;
            }
            booksChecked++;
        }
        if(isFound == false){
            System.out.println("The book you search is not here!");
            System.out.println("You checked " + booksChecked + " books.");
        }
    }

}
