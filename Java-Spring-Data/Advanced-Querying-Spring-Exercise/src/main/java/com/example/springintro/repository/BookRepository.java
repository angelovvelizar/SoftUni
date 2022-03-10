package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    //List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b FROM Book b WHERE b.editionType = 2 AND b.copies < 5000 ")
    List<Book> findAllByEditionTypeAndCopiesLessThan();


    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    @Query("SELECT b FROM Book b WHERE SUBSTRING(b.releaseDate,1,4) <> :releaseDate")
    List<Book> findAllByReleaseDateIsNot(String releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByTitleContainingIgnoreCase(String title);

    List<Book> findAllByAuthor_LastNameStartsWith(String author_lastName);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :number ")
    Integer countAllByTitleIsGreaterThan(int number);

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b" +
            " WHERE b.title = :title")
    List<Object[]> findBookByTitle(String title);



}
