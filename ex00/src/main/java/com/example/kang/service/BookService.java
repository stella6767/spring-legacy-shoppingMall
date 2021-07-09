package com.example.kang.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.kang.domain.book.Book;
import com.example.kang.domain.kakaoapi.Document;
import com.example.kang.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	private final BookRepository bookRepository;
	
	
	
	public List<Book> findAll(){
		
		List<Book> books = bookRepository.findAll();
		
		
		return books;
	}
	
	
	public void insertAll(List<Document> documents) {
		
		
		log.info("insertAll 서비스 들어옴");
				
		for (Document document : documents) {
						
			log.info("document: " + document.toString());
			
			Book book = Book.builder()
				.author(document.getAuthors().isEmpty() ? " ":  document.getAuthors().get(0) )
				.contents(document.getContents())
				.datetime(document.getDatetime())
				.isbn(document.getIsbn())
				.price(document.getPrice())
				.publisher(document.getPublisher())
				.salePrice(document.getSalePrice())
				.url(document.getUrl())
				.translator(document.getTranslators().isEmpty() ? "": document.getTranslators().get(0) )
				.thumbnail(document.getThumbnail())
				.status(document.getStatus())
				.title(document.getTitle())
				.build();
				
			
			log.info(book.toString());
			
			//bookRepository.save(book);
			
			
		}
		
	}
	
	
}