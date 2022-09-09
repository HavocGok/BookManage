package com.example.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootDemo.dao.BookDao;
import com.example.SpringBootDemo.entity.Book;
@Service
public class BookService {
	@Autowired
	private BookDao bl;
	
	
	public String addBook(Book b)
	{
		bl.save(b);
		return "Book Added";
	}
	
	public String viewBook(int bid)
	{
		Book b = bl.findById(bid).orElse(null);
		if(b!=null)
		{
			return b.toString();
		}
		return "Book Unavailable";
	}
	
	public String viewAllBook()
	{
		return bl.findAll().toString();
	}
	public String updateBook(Book b)
	{
		for(Book b1 : bl.findAll())
		{
			if(b1.getBid() == b.getBid())
			{
				bl.deleteById(b.getBid());
			}
		}
		bl.save(b);
		return "Book updated";
	}
	
	public String deleteBook(int bid) {
		for(Book b : bl.findAll())
		{
			if(bid == b.getBid())
			{
				bl.deleteById(bid);
				return "Book Deleted";
			}
		}
		return "Book unavailable";
	}
}

