package com.codegym.book;

import com.codegym.book.repository.BookRepository;
import com.codegym.book.service.BookService;
import com.codegym.book.service.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	public BookService bookService(){
		return new BookServiceImpl();
	}

}

