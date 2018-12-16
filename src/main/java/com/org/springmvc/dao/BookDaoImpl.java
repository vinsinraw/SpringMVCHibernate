package com.org.springmvc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.org.springmvc.form.Book;

@Repository
public class BookDaoImpl implements BookDao {
	private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addBook(Book book) {
		//sessionFactory.getCurrentSession().save(book);	? What is diff between save and persist?
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		logger.info("Book saved successfully, Book Details="+book);
	}

	@Override
	public void removeBook(int id) {
/*		Book book = (Book)sessionFactory.getCurrentSession()
			.load(Book.class, id);
		if(null != book) {
			sessionFactory.getCurrentSession().delete(book);
		}*/
		
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		if(null != book){
			session.delete(book);
		}
		logger.info("Book deleted successfully, book details="+book);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		// return sessionFactory.getCurrentSession().createQuery("from Book").list();
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> booksList = session.createQuery("from Book").list();
		for(Book book : booksList){
			logger.info("Book List::"+book);
		}
		return booksList;
	}

	@Override
	public void updateBook(Book book) {
		//sessionFactory.getCurrentSession().update(book);
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		logger.info("Book updated successfully, book Details="+book);
	}
	
	@Override
	public Book getBookById(int bookId) {
		/*Session session = sessionFactory.getCurrentSession();
		List<Book> list = session.createQuery("from Book b where b.id = :bookId")
			.setParameter("bookId", bookId)
			.list();
		return list.size() > 0 ?(Book)list.get(0): null;*/
		
		Session session = this.sessionFactory.getCurrentSession();		
		Book book = (Book) session.load(Book.class, new Integer(bookId));
		logger.info("Book loaded successfully, Book details="+book);
		return book;
	}
}
