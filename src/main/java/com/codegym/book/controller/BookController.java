package com.codegym.book.controller;

import com.codegym.book.model.Book;
import com.codegym.book.repository.BookRepository;
import com.codegym.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ModelAndView book(@PageableDefault(5)Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        return new ModelAndView("list", "book",books);
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        return new ModelAndView("create","book",new Book());
    }

    @PostMapping("/create")
    public ModelAndView save(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("create",new Book());
            return modelAndView;
        }else {
            bookService.save(book);
            modelAndView.addObject("message","create sucessfully!");
            return modelAndView;
        }
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("edit","book",book);
    }
    @PostMapping("edit")
    public ModelAndView editBook(@Validated @ModelAttribute("book") Book book,BindingResult result){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        } else {
            bookService.save(book);
            modelAndView.addObject("message","successful");
            return modelAndView;
        }

    }
    @GetMapping("delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("delete","book",book);
    }
    @PostMapping("delete")
    public ModelAndView deleteBook(@ModelAttribute("book") Book book){
        bookService.remove(book.getID());
        return new ModelAndView("redirect:books");
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam ("search") String search,@PageableDefault(3) Pageable pageable){
        Page<Book> books = bookService.findByCode(search,pageable);
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("search", search);
        modelAndView.addObject("asd",books);

        return modelAndView;
    }
}
