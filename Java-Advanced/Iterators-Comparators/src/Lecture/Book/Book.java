package Lecture.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;


    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        /*if(authors.length == 0){
            this.authors = new ArrayList<>();
        }else{
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }*/
        this.authors = Arrays.asList(authors);
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);

    }

    @Override
    public int compareTo(Book book) {
        if(this.getTitle().compareTo(book.title) == 0){
            return Integer.compare(this.getYear(), book.getYear());
        }

        return this.getTitle().compareTo(book.title);
    }

}
