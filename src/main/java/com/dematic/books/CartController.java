package com.dematic.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private BookService bookService;

    public CartController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("cart")
    public List<Book> cart() {
        return new ArrayList<>();
    }

    @GetMapping
    public String openCart(Model model) {
        return "cart";
    }


    @GetMapping("/add/{barcode}")
    public String addToCart(@PathVariable Long barcode, @ModelAttribute("cart") List<Book> cart, Model model) {
        cart.add(bookService.getBook(barcode));
        return "cart";
    }
}
