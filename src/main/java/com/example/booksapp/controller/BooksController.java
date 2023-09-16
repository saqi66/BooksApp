package com.example.booksapp.controller;

import com.example.booksapp.dto.BooksDto;
import com.example.booksapp.dto.request.BooksRequest;
import com.example.booksapp.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BooksController {


    final BooksService booksService;

    @GetMapping(value = "/BooksList")
    public List<BooksDto> getBooksInfo() {

        return booksService.getAll();
    }

    @GetMapping(value = "/getBooksById/{id}")
    public BooksDto getBooksById(@PathVariable(value = "id") Long id) {
        return booksService.getBooksById(id);
    }

    @PostMapping(value = "/saveBooks")
    public void saveBooks(@RequestBody BooksRequest booksRequest) {
        booksService.saveBooks(booksRequest);
    }

    @PostMapping(value = "/updateBooks")
    public void updateBooks(@RequestBody BooksRequest booksRequest) {
        booksService.updateBooks(booksRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

        booksService.deleteById(id);
    }
}







