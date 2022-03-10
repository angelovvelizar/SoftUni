package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;



    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {

        String message = "Please enter exercise number or type 'Exit': ";

        System.out.println(message);
        String input = bufferedReader.readLine();
        while (!input.equals("Exit")) {

            switch (input) {
                case "1":
                    exerciseOne();
                    break;
                case "2":
                    exerciseTwo();
                    break;
                case "3":
                    exerciseThree();
                    break;
                case "4":
                    exerciseFour();
                    break;
                case "5":
                    exerciseFive();
                    break;
                case "6":
                    exerciseSix();
                    break;
                case "7":
                    exerciseSeven();
                    break;
                case "8":
                    exerciseEight();
                    break;
                case "9":
                    exerciseNine();
                    break;
                case "10":
                    exerciseTen();
                    break;
                case "11":
                    exerciseEleven();
                    break;
                default:
                    System.out.println("Invalid exercise!");
                    break;
            }
            System.out.println(message);
            input = bufferedReader.readLine();
        }
    }

    private void exerciseTen() {
        this.authorService.findAllAuthorsAndTheirTotalCopies().forEach(System.out::println);
    }

    private void exerciseEleven() throws IOException {
        System.out.println("Please enter title: ");
        String title = bufferedReader.readLine();

        System.out.println(this.bookService.findBookByTitle(title));
    }

    private void exerciseNine() throws IOException {
        System.out.println("Please enter number: ");
        int number = Integer.parseInt(bufferedReader.readLine());

        int countOfBooks = this.bookService.countAllByTitleIsGreaterThan(number);

        String output = countOfBooks > 0 ? String.format("There are %d books with longer title than %d symbols"
        ,countOfBooks,number) : String.format("There are no books with title longer than %d", number);

        System.out.println(output);


    }

    private void exerciseEight() throws IOException {
        System.out.println("Please enter sequence that author's last name starts with: ");
        String sequence = bufferedReader.readLine();

        this.bookService.findAllByAuthor_LastNameStartsWith(sequence)
                .forEach(System.out::println);
    }

    private void exerciseSeven() throws IOException {
        System.out.println("Please enter sequence that the title contains: ");
        String sequence = bufferedReader.readLine();
        this.bookService.findAllByTitleContainingIgnoreCase(sequence)
                .forEach(System.out::println);
    }

    private void exerciseSix() throws IOException {
        System.out.println("Please enter last characters of first name: ");
        String nameEnding = bufferedReader.readLine();

        this.authorService.findAllByFirstNameEndingWith(nameEnding)
                .forEach(System.out::println);
    }

    private void exerciseFive() throws IOException {
        System.out.println("Please enter release date(dd-MM-yyyy): ");
        String[] dateParts = bufferedReader.readLine().split("-");


        LocalDate releaseDate = LocalDate.of(Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[0]));

        this.bookService.findAllByReleaseDateBefore(releaseDate)
                .forEach(System.out::println);

    }

    private void exerciseFour() throws IOException {
        System.out.println("Please enter release date: ");
        String releaseDate = bufferedReader.readLine();

        this.bookService.findAllByReleaseDateIsNot(releaseDate)
                .forEach(System.out::println);
    }

    private void exerciseThree() {
        this.bookService.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal("5"),new BigDecimal("40"))
                .forEach(System.out::println);
    }

    private void exerciseTwo() {
        this.bookService.findAllByEditionTypeAndCopiesLessThan()
                .forEach(System.out::println);
    }

    private void exerciseOne() throws IOException {
        System.out.println("Please enter age restriction (minor, teen or adult): ");
        String ageRestrictionType = bufferedReader.readLine().toUpperCase();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionType);

        this.bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }
}
