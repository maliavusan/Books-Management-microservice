package com.management.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
