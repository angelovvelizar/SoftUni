package Lecture.Book;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }


    private final class LibIterator implements Iterator<Book>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
            Book nextBook = books[counter];
            counter++;
            return nextBook;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
