package com.example.booksapp.controller;

import com.example.booksapp.dto.GenresDto;
import com.example.booksapp.dto.request.GenresRequest;
import com.example.booksapp.service.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/genres")
public class GenresController {


    final GenresService genresService;

    @GetMapping(value = "/GenresList")
    public List<GenresDto> getGenresInfo() {

        return genresService.getAll();
    }

    @GetMapping(value = "/getGenresById/{id}")
    public GenresDto getGenresById(@PathVariable(value = "id") Long id) {
        return genresService.getGenresById(id);
    }

    @PostMapping(value = "/saveGenres")
    public void saveGenres(@RequestBody GenresRequest genresRequest) {
        genresService.saveGenres(genresRequest);
    }

    @PostMapping(value = "/updateGenres")
    public void updateGenres(@RequestBody GenresRequest genresRequest) {
        genresService.updateGenres(genresRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

        genresService.deleteById(id);
    }
}







