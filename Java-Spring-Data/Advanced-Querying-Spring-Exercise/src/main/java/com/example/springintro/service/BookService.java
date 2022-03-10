package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan();

    List<String> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<String> findAllByReleaseDateIsNot(String releaseDate);

    List<String> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<String> findAllByTitleContainingIgnoreCase(String title);

    List<String> findAllByAuthor_LastNameStartsWith(String author_lastName);

    Integer countAllByTitleIsGreaterThan(int number);

    String findBookByTitle(String title);

}
