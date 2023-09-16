package com.example.booksapp.repository;

import com.example.booksapp.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Books getBooksById(Long id);

}
