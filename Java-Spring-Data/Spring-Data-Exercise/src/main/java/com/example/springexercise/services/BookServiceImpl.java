package com.example.springexercise.services;

import com.example.springexercise.enums.AgeRestriction;
import com.example.springexercise.enums.EditionType;
import com.example.springexercise.models.entities.Author;
import com.example.springexercise.models.entities.Book;
import com.example.springexercise.models.entities.Category;
import com.example.springexercise.repositories.AuthorRepository;
import com.example.springexercise.repositories.BookRepository;
import com.example.springexercise.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final String BOOKS_PATH = "src/main/resources/books.txt";
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOKS_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = getBook(bookInfo);
                    bookRepository.save(book);
                });

    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year,12,31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBefore(int year) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year,1,1))
                .stream()
                .map(b -> String.format("%s %s", b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName,lastName)
                .stream()
                .map(book -> String.format("Title: %s, Release date: %s, Copies: %d", book.getTitle()
                ,book.getReleaseDate(),book.getCopies()))
                .collect(Collectors.toList());

    }

    private Book getBook(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate date = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo).skip(5).collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType, date, copies, price, ageRestriction, title, author, categories);

    }
}
