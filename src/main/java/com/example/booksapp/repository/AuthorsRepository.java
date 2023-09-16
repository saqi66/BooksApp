package com.example.booksapp.repository;

import com.example.booksapp.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long>{

    Authors getAuthorsById(Long id);

}
