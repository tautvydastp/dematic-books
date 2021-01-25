package com.dematic.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{barcode}")
    public String getBook(@PathVariable Long barcode, Model model){
        Book book = bookService.getBook(barcode);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/book/{barcode}")
    public String getUpdateBookForm(@PathVariable Long barcode, Model model){
        Book book = bookService.getBook(barcode);
        model.addAttribute("book", book);
        return "bookform";
    }

    @GetMapping("/book")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @GetMapping("/books/book/{barcode}/delete")
    public String deleteBook(@PathVariable Long barcode, Model model){
        bookService.deleteBook(barcode);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/book")
    public String submitBook(Book book, BindingResult errors, Model model){

        if (errors.hasErrors()){
            return "bookform";
        }
        Book newBook = bookService.createOrUpdateBook(book);
        model.addAttribute("book", newBook);
        return "redirect:/books/" + newBook.getBarcode();
    }

    @GetMapping("/%7Bbarcode%7D?{barcode}")
    public String getBookByBarcode(@PathVariable Long barcode, Model model){
        Book book = bookService.getBook(barcode);
        model.addAttribute("book", book);
        return "books";
    }

}
