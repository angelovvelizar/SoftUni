package com.example.springexercise.controller;

import com.example.springexercise.models.entities.Book;
import com.example.springexercise.services.AuthorService;
import com.example.springexercise.services.BookService;
import com.example.springexercise.services.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //TODO: Please uncomment the method you want to test

        //printAllBooksAfter();

        //printAllAuthorsNamesWithBooksReleaseDateBefore();

        //printAllAuthorsAndNumberOfTheirBooks();

        //printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");


    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName,lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfBooks()
                .forEach(System.out::println);

    }

    private void printAllAuthorsNamesWithBooksReleaseDateBefore() {
        bookService.findAllAuthorsWithBooksWithReleaseDateBefore(1990)
                .forEach(System.out::println);
    }

    private void printAllBooksAfter() {
        List<Book> booksAfterYear = this.bookService.findAllBooksAfterYear(2000);
        booksAfterYear.forEach(b -> System.out.println(b.getTitle()));
    }

    private void seedData() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }
}
