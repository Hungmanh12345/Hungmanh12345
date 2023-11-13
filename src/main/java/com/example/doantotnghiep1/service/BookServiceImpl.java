package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Book;
import com.example.doantotnghiep1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
        }

    @Override
    public Book update(String id, Book book){
        Book existBook = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        existBook
                .bookName(book.getBookName())
                .phone(book.getPhone());
        return bookRepository.save(existBook);
    }


    @Override
    public Book getBookById(String id){
        return bookRepository.findById(id).get();
    }


    @Override
    public List<Book> getBook(){
        return bookRepository.findAll();
    }

}
