package com.example.springexercise.services;

import com.example.springexercise.models.entities.Author;
import com.example.springexercise.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AuthorServiceImpl implements AuthorService{
    private static final String AUTHORS_PATH = "src/main/resources/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {
        if(authorRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(AUTHORS_PATH)).forEach(row -> {
                    String[] fullName = row.split("\\s+");

                    Author author = new Author(fullName[0],fullName[1]);
                    this.authorRepository.save(author);
                });


    }
}
