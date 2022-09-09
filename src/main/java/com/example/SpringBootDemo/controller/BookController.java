package com.example.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringBootDemo.entity.Book;
import com.example.SpringBootDemo.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@RequestMapping("addbook")
	@ResponseBody
	public String addBook(Book b)
	{
		/*
		 * int bid = Integer.parseInt(req.getParameter("bid")); String bname =
		 * req.getParameter("bname"); String bauthor = req.getParameter("bauthor");
		 * double bcost = Double.parseDouble(req.getParameter("bcost"));
		 */
		//Book b = new Book(bid, bname, bauthor, bcost);
		return bs.addBook(b);
	}
	@RequestMapping("index")
	
	public String getBookHome(){
		return "index.jsp";
	}
	
	@RequestMapping("viewbook")
	@ResponseBody
	public String viewBook(int bid){
		return bs.viewBook(bid);
	}
	
	@RequestMapping("viewallbook")
	@ResponseBody
	public String viewAllBook(){
		return bs.viewAllBook();
	}
	
	@RequestMapping("updatebook")
	@ResponseBody
	public String updateBook(Book b)
	{
		return bs.updateBook(b);
	}
	
	@RequestMapping("deletebook")
	@ResponseBody
	public String deleteBook(int bid){
		return bs.deleteBook(bid);
	}
	
}

