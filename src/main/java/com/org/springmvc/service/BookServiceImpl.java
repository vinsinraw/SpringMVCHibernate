package com.org.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.org.springmvc.dao.BookDao;
import com.org.springmvc.form.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired 
	private BookDao bookDao;

	public void setBookDAO(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Transactional
	public void addBook(Book book) {
		this.bookDao.addBook(book);
	}

	@Transactional
	public void removeBook(int id) {
		this.bookDao.removeBook(id);
	}

	@Transactional
	public List<Book> listBooks() {
		return this.bookDao.listBooks();
	}

	@Transactional
	public void updateBook(Book book) {
		this.bookDao.updateBook(book);
	}

	@Transactional
	public Book getBookById(int bookId) {
		return this.bookDao.getBookById(bookId);
	}
}