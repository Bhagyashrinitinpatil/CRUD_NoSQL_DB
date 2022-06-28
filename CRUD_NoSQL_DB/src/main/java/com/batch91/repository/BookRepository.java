package com.batch91.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.batch91.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

	
	

}
