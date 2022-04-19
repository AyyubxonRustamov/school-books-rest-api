package com.example.maktabdarsliklari.controller;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.UserDTO;
import com.example.maktabdarsliklari.repository.UserRepository;
import com.example.maktabdarsliklari.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;
    final UserRepository userRepository;

    @PostMapping
    public HttpEntity add(@RequestBody UserDTO userDTO) {
        ApiResponse apiResponse = userService.save(userDTO);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity getOne(@PathVariable Long id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @GetMapping()
    public HttpEntity getAll() {
        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity edit(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        ApiResponse apiResponse = userService.update(id, userDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity delete(@PathVariable Long id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @PutMapping("/addBookmark/{userId}&{bookId}")
    public HttpEntity addBookmark(@PathVariable Long userId, @PathVariable Long bookId){
        ApiResponse apiResponse = userService.addBookmark(userId, bookId);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @PutMapping("/removeBookmark/{userId}&{bookId}")
    public HttpEntity removeBookmark(@PathVariable Long userId, @PathVariable Long bookId){
        ApiResponse apiResponse = userService.removeBookmark(userId, bookId);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
