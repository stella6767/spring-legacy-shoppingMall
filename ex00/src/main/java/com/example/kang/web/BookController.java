package com.example.kang.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kang.domain.book.Book;
import com.example.kang.handler.customException.MyNullException;
import com.example.kang.service.BookService;
import com.example.kang.utils.Script;
import com.github.pagehelper.Page;

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
	
	
	@GetMapping("book/list")
	public String list(Model model) {
		
		log.info("전체 리스트");	
		
		List<Book> books = bookService.findAll();
		model.addAttribute("books",books);
		
		
		return "booklist";
	}
	
	
	@GetMapping("book/list2")
	public @ResponseBody Page<Book> list2(int page) {
		
		log.info("스크롤 리스트");	
		
		Page<Book> pages = bookService.pageTest(page);
		
		//신기하게 pages 안에 books 배열만 리턴하네..		
		return pages;
	}
	
	
	@GetMapping("book/list22")
	public String mainlist() {
		
		log.info("mainpage");
		
		return "booklist2";
		
	}
	
	
	
	@GetMapping("book/item/{id}")
	public String item(Model model, @PathVariable int id, HttpServletResponse resp) {
		
		log.info("상세보기 " + id);	
		
		Book book = bookService.findById(id);
		
		if(book == null) {
			throw new MyNullException();
		}
		
		
		model.addAttribute("book", book);
	
		return "bookitem";
	}
	
	

		
	
}
