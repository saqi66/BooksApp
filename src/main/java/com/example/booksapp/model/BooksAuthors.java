package com.example.booksapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books_authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksAuthors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "is_main_author")
    private boolean isMainAuthor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private Authors authors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_id")
    private Books books;

}
