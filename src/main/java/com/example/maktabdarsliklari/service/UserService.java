package com.example.maktabdarsliklari.service;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.UserDTO;
import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.entity.User;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;
    final BookRepository bookRepository;

    public ApiResponse save(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        if (!userDTO.getBookIds().isEmpty()){
            for (Long bookId : userDTO.getBookIds()) {
                Optional<Book> optionalBook = bookRepository.findById(bookId);
                if (optionalBook.isEmpty()) return new ApiResponse("Book Not Found", false);

                user.getLikedBooks().add(optionalBook.get());
            }
        }
        userRepository.save(user);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse getOne(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return new ApiResponse("User Not Found", false);
        return new ApiResponse("One", true, optionalUser.get());
    }

    public ApiResponse getAll() {
        List<User> all = userRepository.findAll();
        return new ApiResponse("All", true, all);
    }

    public ApiResponse update(Long id, UserDTO userDTO) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return new ApiResponse("User Not Found", false);

        User edited = optionalUser.get();
        edited.setName(userDTO.getName());
        edited.setPassword(userDTO.getPassword());
        edited.setPhone(userDTO.getPhone());
        if (!userDTO.getBookIds().isEmpty()){
            for (Long bookId : userDTO.getBookIds()) {
                Optional<Book> optionalBook = bookRepository.findById(bookId);
                if (optionalBook.isEmpty()) return new ApiResponse("Book Not Found", false);

                edited.getLikedBooks().add(optionalBook.get());
            }
        }
        userRepository.save(edited);
        return new ApiResponse("Updated", true);
    }

    public ApiResponse delete(Long id){

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return new ApiResponse("User Not Found", false);

        userRepository.delete(optionalUser.get());
        return new ApiResponse("Deleted", true);
    }

    public ApiResponse addBookmark(Long userId, Long bookId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalUser.isEmpty() | optionalBook.isEmpty()) return
                new ApiResponse("User or Book Not Found", false);

        User user = optionalUser.get();
        user.getLikedBooks().add(optionalBook.get());

        return new ApiResponse("Book Successfully Added", true);
    }

    public ApiResponse removeBookmark(Long userId, Long bookId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalUser.isEmpty() | optionalBook.isEmpty()) return
                new ApiResponse("User or Book Not Found", false);

        User user = optionalUser.get();
        user.getLikedBooks().remove(optionalBook.get());

        return new ApiResponse("Book Successfully Removed", true);
    }
}
