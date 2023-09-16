package com.example.booksapp.service.impl;

import com.example.booksapp.dto.AuthorsDto;
import com.example.booksapp.dto.request.AuthorsRequest;
import com.example.booksapp.exeption.ResourceNotFoundException;
import com.example.booksapp.model.Authors;
import com.example.booksapp.repository.AuthorsRepository;
import com.example.booksapp.service.AuthorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;

    @Override
    public AuthorsDto getAuthorsById(Long id) {
        Authors authors = authorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Authors", "id", id));
        return AuthorsDto.builder()
                .name(authors.getName())
                .bio(authors.getBio())
                .build();
    }

    @Override
    public void saveAuthors(AuthorsRequest authorsRequest) {
        Authors authors = Authors.builder()
                .name(authorsRequest.getName())
                .bio(authorsRequest.getBio())
                .build();
        authorsRepository.save(authors);
    }

    @Override
    public void updateAuthors(AuthorsRequest authorsRequest) {
        Authors authors = Authors.builder()
                .id(authorsRequest.getId())
                .name(authorsRequest.getName())
                .bio(authorsRequest.getBio())
                .build();
        authorsRepository.save(authors);
    }

    @Override
    public List<AuthorsDto> getAll() {
        List<Authors> authors = authorsRepository.findAll();
        List<AuthorsDto> authorsDtos = new ArrayList<>();

        for (Authors authors1 : authors) {
            AuthorsDto authorsDto = AuthorsDto.builder()
                    .name(authors1.getName())
                    .bio(authors1.getBio())
                    .build();

            authorsDtos.add(authorsDto);
        }

        return authorsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Authors authors = authorsRepository.getAuthorsById(id);
        if (authors == null) {
            throw new ResourceNotFoundException("Authors", "id", id);
        } else {
            authorsRepository.deleteById(id);
        }
    }
}




