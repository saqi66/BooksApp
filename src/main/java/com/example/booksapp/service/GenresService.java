package com.example.booksapp.service;

import com.example.booksapp.dto.GenresDto;
import com.example.booksapp.dto.request.GenresRequest;

import java.util.List;

public interface GenresService {

    GenresDto getGenresById(Long id);

    void saveGenres (GenresRequest genresRequest);

    void updateGenres (GenresRequest genresRequest);

    List<GenresDto> getAll();

    void deleteById(Long id);

}
