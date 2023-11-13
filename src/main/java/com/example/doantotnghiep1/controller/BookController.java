package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Book;
import com.example.doantotnghiep1.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addTable")
    public String add(Model model){
        Book book = new Book();
        boolean isNewOrder = true;
        model.addAttribute("bookTable", book);
        model.addAttribute("isNewOrder", isNewOrder);
        return "BookTable";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("bookTable") Book book){
         book
                .bookName(book.getBookName())
                .phone(book.getPhone())
                .quantity(book.getQuantity())
                .date(book.getDate())
                .time(book.getTime())
                .information(book.getInformation())
                .action("Chưa duyệt");
        bookService.save(book);
        return "redirect:/book/notification";
    }

    @GetMapping("/notification")
    public String notification(){
        return "notification";
    }

    @GetMapping("/getBook")
    public String getBook(Model model){
        model.addAttribute("getBook", bookService.getBook());
        return "confirmBook";
    }
    @PostMapping("/confirm/{id}")
    public String confirmBooking(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        book.setAction("Đã duyệt");
        bookService.save(book);
        return "redirect:/book/getBook";
    }
    @PostMapping("/delete/{id}")
    public String deleteBooking(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        book.setAction("Đã Hủy");
        bookService.save(book);
        return "redirect:/book/getBook";
    }

    @GetMapping("/list_book_customer")
    public String ListBookCustomer(Model model){
        model.addAttribute("show", bookService.getBook());
        return "listBookCustomer";
    }
   @PostMapping("/bookId/{id}")
    public String bookById(@PathVariable String id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);

        return "redirect:/table";
    }

    @GetMapping("/table/{id}")
    public String bookId(@PathVariable String id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "table";
    }
}
