package com.example.booksapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authors {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "name")
   private String name;
   @Column(name = "bio")
   private String bio;

   @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<BooksAuthors> booksAuthorses = new ArrayList<>();

   @ManyToMany
   @JoinTable(name = "books_authors",
           joinColumns = @JoinColumn(name = "author_id"),
           inverseJoinColumns = @JoinColumn(name = "books_id"))
   private List<Books> bookses = new ArrayList<>();

}
