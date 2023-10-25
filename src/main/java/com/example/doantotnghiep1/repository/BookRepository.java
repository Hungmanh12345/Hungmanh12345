package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

    Book findByBookName(String bookName);

    Book findByPhone(String phone);
}
