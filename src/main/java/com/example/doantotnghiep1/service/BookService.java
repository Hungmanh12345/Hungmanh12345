package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Book;

import java.util.List;

public interface BookService {


    Book save(Book book);

    Book update(String id, Book book);

    Book getBookById(String id);

    List<Book> getBook();


}
