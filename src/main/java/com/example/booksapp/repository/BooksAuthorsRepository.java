package com.example.booksapp.repository;

import com.example.booksapp.model.BooksAuthors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksAuthorsRepository extends JpaRepository<BooksAuthors, Long> {

    BooksAuthors getBooksAuthorsByAuthorId(Long authorId);

}
