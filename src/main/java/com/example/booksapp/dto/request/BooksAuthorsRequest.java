package com.example.booksapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksAuthorsRequest {

    private Long bookId;
    private Long authorId;
    private boolean isMainAuthor;

}
