package com.example.booksapp.service.impl;

import com.example.booksapp.dto.BooksAuthorsDto;
import com.example.booksapp.dto.request.BooksAuthorsRequest;
import com.example.booksapp.exeption.ResourceNotFoundException;
import com.example.booksapp.model.Authors;
import com.example.booksapp.model.BooksAuthors;
import com.example.booksapp.repository.BooksAuthorsRepository;
import com.example.booksapp.service.BooksAuthorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BooksAuthorsServiceImpl implements BooksAuthorsService {

    private final BooksAuthorsRepository booksAuthorsRepository;

    @Override
    public BooksAuthorsDto getBooksAuthorsById(Long id) {
        BooksAuthors booksAuthors = booksAuthorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BooksAuthors", "id", id));
        return BooksAuthorsDto.builder()
                .isMainAuthor(booksAuthors.isMainAuthor())
                .build();
    }

    @Override
    public void saveBooksAuthors(BooksAuthorsRequest request) {
        BooksAuthors booksAuthors = BooksAuthors.builder()
                .isMainAuthor(request.isMainAuthor())
                .build();
        booksAuthorsRepository.save(booksAuthors);
    }

    @Override
    public void updateBooksAuthors(BooksAuthorsRequest booksAuthorsRequest) {
        BooksAuthors booksAuthors = BooksAuthors.builder()
                .authorId(booksAuthorsRequest.getAuthorId())
                .isMainAuthor(booksAuthorsRequest.isMainAuthor())
                .build();
        booksAuthorsRepository.save(booksAuthors);
    }

    @Override
    public List<BooksAuthorsDto> getAll() {
        List<BooksAuthors> list = booksAuthorsRepository.findAll();
        List<BooksAuthorsDto> dtos = new ArrayList<>();

        for (BooksAuthors item : list) {
            BooksAuthorsDto dto = BooksAuthorsDto.builder()
                    .isMainAuthor(item.isMainAuthor())
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void deleteById(Long id) {
        BooksAuthors booksAuthors = booksAuthorsRepository.getBooksAuthorsByAuthorId(id);
        if (booksAuthors == null) {
            throw new ResourceNotFoundException("BooksAuthors", "id", id);
        } else {
            booksAuthorsRepository.deleteById(id);
        }
    }
}