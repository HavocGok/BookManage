package com.example.SpringBootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootDemo.entity.Book;

public interface BookDao extends JpaRepository<Book,Integer>{

}
