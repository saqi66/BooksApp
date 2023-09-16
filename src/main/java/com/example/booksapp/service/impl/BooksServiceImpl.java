package com.example.booksapp.service.impl;

import com.example.booksapp.dto.BooksDto;
import com.example.booksapp.dto.request.BooksRequest;
import com.example.booksapp.exeption.ResourceNotFoundException;
import com.example.booksapp.model.Books;
import com.example.booksapp.repository.BooksRepository;
import com.example.booksapp.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    @Override
    public BooksDto getBooksById(Long id) {
        Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books", "booksId", id));
        return BooksDto.builder()
                .title(books.getTitle())
                .description(books.getDescription())
                .ISBN(books.getISBN())
                .build();
    }

    @Override
    public void saveBooks(BooksRequest booksRequest) {
        Books books = Books.builder()
                .title(booksRequest.getTitle())
                .description(booksRequest.getDescription())
                .ISBN(booksRequest.getISBN())
                .build();
        booksRepository.save(books);
    }

    @Override
    public void updateBooks(BooksRequest booksRequest) {
        Books books = Books.builder()
                .id(booksRequest.getId())
                .title(booksRequest.getTitle())
                .description(booksRequest.getDescription())
                .ISBN(booksRequest.getISBN())
                .build();
        booksRepository.save(books);
    }

    @Override
    public List<BooksDto> getAll() {
        List<Books> books = booksRepository.findAll();
        List<BooksDto> booksDtos = new ArrayList<>();

        for (Books book : books) {
            BooksDto booksDto = BooksDto.builder()
                    .title(book.getTitle())
                    .description(book.getDescription())
                    .ISBN(book.getISBN())
                    .build();

            booksDtos.add(booksDto);
        }

        return booksDtos;
    }

    @Override
    public void deleteById(Long id) {
        Books books = booksRepository.getBooksById(id);
        if (books == null) {
            throw new ResourceNotFoundException("Books", "booksId", id);
        } else {
            booksRepository.deleteById(id);
        }
    }
}
