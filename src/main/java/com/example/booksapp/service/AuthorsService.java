package com.example.booksapp.service;

import com.example.booksapp.dto.AuthorsDto;
import com.example.booksapp.dto.request.AuthorsRequest;

import java.util.List;

public interface AuthorsService {

    AuthorsDto getAuthorsById(Long id);

    void saveAuthors (AuthorsRequest authorsRequest);

    void updateAuthors (AuthorsRequest authorsRequest);

    List<AuthorsDto> getAll();

    void deleteById(Long id);


}
