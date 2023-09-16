package com.example.booksapp.service;

import com.example.booksapp.dto.BooksDto;
import com.example.booksapp.dto.request.BooksRequest;
import com.example.booksapp.model.Books;

import java.util.List;

public interface BooksService {

    BooksDto getBooksById(Long id);

    void saveBooks (BooksRequest booksRequest);

    void updateBooks (BooksRequest booksRequest);

    List<BooksDto> getAll();

    void deleteById(Long id);


}
