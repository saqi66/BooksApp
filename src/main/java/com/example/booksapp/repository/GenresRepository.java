package com.example.booksapp.repository;

import com.example.booksapp.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long> {

    Genres getGenresById(Long id);

}
