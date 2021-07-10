package com.example.kang.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kang.domain.kakaoapi.Data;
import com.example.kang.domain.kakaoapi.Document;
import com.example.kang.service.BookService;
import com.example.kang.utils.BookApiTest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	private final BookService bookService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
		@RequestMapping(value="/api/insert/{page}", produces="application/json;charset=UTF-8", method=RequestMethod.GET)
		public @ResponseBody String insertApiData(@PathVariable int page) {
			
			
			log.info("api insert " + page);
			
			List<Document> documents = BookApiTest.getApi(page);
			
			if(documents != null) {
				bookService.insertAll(documents);
				
				return "성공";
			}
			
			
			return "실패!";
		}
	
	
	
	
}
