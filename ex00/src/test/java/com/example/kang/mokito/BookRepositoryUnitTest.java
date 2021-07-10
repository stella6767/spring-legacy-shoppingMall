package com.example.kang.mokito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.kang.domain.book.Book;
import com.example.kang.repository.BookRepository;
import com.example.kang.service.BookService;
import com.github.pagehelper.Page;

import lombok.extern.log4j.Log4j;
 
@Log4j
public class BookRepositoryUnitTest {

	
	@InjectMocks//BookService 객체가 만들어질 때 BookServiceUnitTest(해당 파일)에 @Mock로 등록된 모든 애들을 주입받는다.
	private BookService bookService;

	
	@Mock
	private BookRepository bookRepository;
	
	
	@Test
	public void 저장하기_테스트() { //안 되네..
		//BDDMocikto 방식
		//given		
		Book book = new Book();
		book.setTitle("책제목1");
		book.setAuthor("책저자1");
		//stub 동작 지정
		when(bookRepository.save(book)).thenReturn(book);	
		//test execute
		Book bookEntity = bookService.save(book);
		//then
		assertEquals(bookEntity, book);		
	}

	
}
