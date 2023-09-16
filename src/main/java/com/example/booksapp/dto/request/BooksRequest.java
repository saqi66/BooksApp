package com.example.booksapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksRequest {
    private Long id;
    private Long genreId;
    private String title;
    private String description;
    private String ISBN;
}
