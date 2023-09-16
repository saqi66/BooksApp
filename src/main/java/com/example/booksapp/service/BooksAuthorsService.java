package com.example.booksapp.service;

import com.example.booksapp.dto.BooksAuthorsDto;
import com.example.booksapp.dto.request.BooksAuthorsRequest;
import com.example.booksapp.model.BooksAuthors;

import java.util.List;

public interface BooksAuthorsService {

    BooksAuthorsDto getBooksAuthorsById(Long id);

    void saveBooksAuthors (BooksAuthorsRequest booksAuthorsRequest);

    void updateBooksAuthors (BooksAuthorsRequest booksAuthorsRequest);

    List<BooksAuthorsDto> getAll();

    void deleteById(Long id);

}
