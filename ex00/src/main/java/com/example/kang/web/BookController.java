package com.example.kang.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kang.domain.book.Book;
import com.example.kang.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	private final BookService bookService;
		
	
	@GetMapping("book/findAll")
	public @ResponseBody List<Book> findAll(){
		
		log.info("리스트 뿌리기");
			
		return bookService.findAll();	
	}
	
	
}
