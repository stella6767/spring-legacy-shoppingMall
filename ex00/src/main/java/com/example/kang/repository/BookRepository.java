package com.example.kang.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.kang.domain.beans.Criteria;
import com.example.kang.domain.book.Book;
import com.example.kang.domain.kakaoapi.Document;
import com.example.kang.domain.kakaoapi.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@Repository
@Mapper
public interface BookRepository {

	public Book save(Book book); 
	public void deleteById(int id);
	public List<Book> findAll();
	public Book findById(int id);
	public List<Book> findListWithPaging(Criteria cri);
	public Page<Book> pageTest();	
}
