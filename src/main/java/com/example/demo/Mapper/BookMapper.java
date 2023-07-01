package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.BookList;

@Mapper
public interface BookMapper {
	
//
	void createBook(BookList bookList);

//
	int getMaxNumberBook();
	
	List<BookList> findBook();
	
	BookList targetBook(int book_id);
	
	void editBook(BookList booklist);
	
	void deleteBook(int booklist);
	
	void rentalBook(int book_id);
	
	void returnBook(int book_id);
	
//	List<BookList> getBookList();
//

}
