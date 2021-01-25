package com.dematic.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(Long barcode) {
        return bookRepository.findById(barcode).
                orElseThrow(() -> new BookNotFoundException("Book with this id was not found"));

    }

    public void deleteBook(Long barcode) {
            bookRepository.deleteById(barcode);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }
}
