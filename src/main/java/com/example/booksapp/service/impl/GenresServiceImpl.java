package com.example.booksapp.service.impl;

import com.example.booksapp.dto.GenresDto;
import com.example.booksapp.dto.request.GenresRequest;
import com.example.booksapp.exeption.ResourceNotFoundException;
import com.example.booksapp.model.Genres;
import com.example.booksapp.repository.GenresRepository;
import com.example.booksapp.service.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {

    private final GenresRepository genresRepository;

    @Override
    public GenresDto getGenresById(Long id) {
        Genres genres = genresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genres", "id", id));
        return GenresDto.builder()
                .name(genres.getName())
                .description(genres.getDescription())
                .build();
    }

    @Override
    public void saveGenres(GenresRequest request) {
        Genres genres = Genres.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        genresRepository.save(genres);
    }

    @Override
    public void updateGenres(GenresRequest request) {
        Genres genres = Genres.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .build();
        genresRepository.save(genres);
    }

    @Override
    public List<GenresDto> getAll() {
        List<Genres> list = genresRepository.findAll();
        List<GenresDto> dtos = new ArrayList<>();

        for (Genres item : list) {
            GenresDto dto = GenresDto.builder()
                    .name(item.getName())
                    .description(item.getDescription())
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void deleteById(Long id) {
        Genres genres = genresRepository.getGenresById(id);
        if (genres == null) {
            throw new ResourceNotFoundException("Genres", "id", id);
        } else {
            genresRepository.deleteById(id);
        }
    }
}