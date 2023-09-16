package com.example.booksapp.controller;

import com.example.booksapp.dto.AuthorsDto;
import com.example.booksapp.dto.request.AuthorsRequest;
import com.example.booksapp.service.AuthorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authors")
public class AuthorsController {

    final AuthorsService authorsService;

    @GetMapping(value = "/authorsList")
    public List<AuthorsDto> getAuthorsInfo() {

        return authorsService.getAll();
    }

    @GetMapping(value = "/getAuthorsById/{id}")
    public AuthorsDto getAuthorsById(@PathVariable(value = "id") Long id) {
        return  authorsService.getAuthorsById(id);
    }

    @PostMapping(value = "/saveAuthors")
    public void saveAuthors(@RequestBody AuthorsRequest authorsRequest) {
        authorsService.saveAuthors(authorsRequest);
    }

    @PostMapping(value = "/updateAuthors")
    public void updateAuthors(@RequestBody AuthorsRequest authorsRequest) {
        authorsService.updateAuthors(authorsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

        authorsService.deleteById(id);
    }
}

