package com.org.springmvc.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books", schema = "test")
public class Book {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="bookName")
	private String bookName;

	@Column(name="author")
	private String author;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	public Integer getId() 
	{return id;}

	public String getBookName() 
	{return bookName;}

	public String getAuthor() 
	{return author;}

	public int getPrice() 
	{return price;}

	public int getQuantity() 
	{return quantity;}

	public void setId(Integer id) 
	{this.id = id;}

	public void setBookName(String bookName) 
	{this.bookName = bookName;}

	public void setAuthor(String author) 
	{this.author = author;}

	public void setPrice(int price) 
	{this.price = price;}

	public void setQuantity(int quantity) 
	{this.quantity = quantity;}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
}
