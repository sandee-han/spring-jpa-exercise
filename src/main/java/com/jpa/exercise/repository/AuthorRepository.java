package com.jpa.exercise.repository;

import com.jpa.exercise.domain.Author;
import com.jpa.exercise.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
//    List<Book> findByName
}
