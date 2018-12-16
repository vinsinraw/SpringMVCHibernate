package com.org.springmvc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.springmvc.dao.BookDaoImpl;
import com.org.springmvc.form.Book;
import com.org.springmvc.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listBooks(Map<String, Object> map) {
		logger.info("listBooks start");
		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());
		logger.info("BookList :: "+bookService.listBooks().toString());
		return "book";
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, BindingResult result) {
		if(null == book.getId()) {
			String bookName = book.getBookName().trim();
			if(bookName != null && !bookName.isEmpty())
				bookService.addBook(book);
		}
		else {
			bookService.updateBook(book);
		}
		return "redirect:/";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") int bookId) {
		bookService.removeBook(bookId);
		return "redirect:/";
	}

	@RequestMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") int bookId, Map<String, Object> map)	{
		map.put("book", bookService.getBookById(bookId));
		map.put("bookList", bookService.listBooks());
		return "book";
	}
}