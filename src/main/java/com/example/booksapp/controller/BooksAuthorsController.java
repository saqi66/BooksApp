package com.example.booksapp.controller;

import com.example.booksapp.dto.BooksAuthorsDto;
import com.example.booksapp.dto.request.BooksAuthorsRequest;
import com.example.booksapp.service.BooksAuthorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/booksauthors")
public class BooksAuthorsController {

    final BooksAuthorsService booksAuthorsService;

    @GetMapping(value = "/BooksAuthorsList")
    public List<BooksAuthorsDto> getBooksAuthorsInfo() {

        return booksAuthorsService.getAll();
    }

    @GetMapping(value = "/getBooksAuthorsById/{id}")
    public BooksAuthorsDto getBooksAuthorsById(@PathVariable(value = "id") Long id) {
        return booksAuthorsService.getBooksAuthorsById(id);
    }

    @PostMapping(value = "/saveBooksAuthors")
    public void saveBooksAuthors(@RequestBody BooksAuthorsRequest booksAuthorsRequest) {
        booksAuthorsService.saveBooksAuthors(booksAuthorsRequest);
    }

    @PostMapping(value = "/updateBooksAuthors")
    public void updateBooksAuthors(@RequestBody BooksAuthorsRequest booksAuthorsRequest) {
        booksAuthorsService.updateBooksAuthors(booksAuthorsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

        booksAuthorsService.deleteById(id);
    }
}




