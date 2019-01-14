package com.codegym.book.service;

import com.codegym.book.model.Book;
import com.codegym.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(findById(id));

    }

    @Override
    public Page<Book> findByCode(String code, Pageable pageable) {
        return bookRepository.findAllByBooksCodeContaining(code,pageable);
    }
}
