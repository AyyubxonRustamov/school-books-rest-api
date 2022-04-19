package com.example.maktabdarsliklari.service;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.BookDTO;
import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.entity.enums.Grade;
import com.example.maktabdarsliklari.entity.enums.Language;
import com.example.maktabdarsliklari.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    final BookRepository bookRepository;

    public ApiResponse save(BookDTO bookDTO) {

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setDescription(bookDTO.getDescription());
        book.setGrade(Grade.getByNumber(bookDTO.getGrade()));
        book.setAuthors(bookDTO.getAuthors());
        book.setLanguage(Language.valueOf(bookDTO.getLanguage().toUpperCase()));
        bookRepository.save(book);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse getOne(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) return new ApiResponse("Book Not Found", false);
        return new ApiResponse("One", true, optionalBook.get());
    }

    public ApiResponse getAll() {
        List<Book> all = bookRepository.findAll();
        return new ApiResponse("All", true, all);
    }

    public ApiResponse update(Long id, BookDTO bookDTO) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) return new ApiResponse("Book Not Found", false);

        Book edited = optionalBook.get();
        edited.setName(bookDTO.getName());
        edited.setDescription(bookDTO.getDescription());
        edited.setGrade(Grade.getByNumber(bookDTO.getGrade()));
        edited.setAuthors(bookDTO.getAuthors());
        edited.setLanguage(Language.valueOf(bookDTO.getLanguage().toUpperCase()));
        bookRepository.save(edited);
        return new ApiResponse("Updated", true);
    }

    public ApiResponse delete(Long id){

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) return new ApiResponse("Book Not Found", false);

        bookRepository.delete(optionalBook.get());
        return new ApiResponse("Deleted", true);
    }
}
