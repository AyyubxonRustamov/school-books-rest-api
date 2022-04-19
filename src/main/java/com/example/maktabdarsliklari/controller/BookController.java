package com.example.maktabdarsliklari.controller;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.BookDTO;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    final BookService bookService;
    final BookRepository bookRepository;

    @PostMapping
    public HttpEntity add(@RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.save(bookDTO);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity getOne(@PathVariable Long id) {
        ApiResponse apiResponse = bookService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @GetMapping()
    public HttpEntity getAll() {
        ApiResponse apiResponse = bookService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity edit(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.update(id, bookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity delete(@PathVariable Long id) {
        ApiResponse apiResponse = bookService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
