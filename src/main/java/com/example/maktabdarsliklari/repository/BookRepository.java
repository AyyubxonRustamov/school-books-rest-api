package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.entity.enums.Grade;
import com.example.maktabdarsliklari.entity.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByGrade(Grade grade);

    List<Book> findAllByLanguage(Language language);

    List<Book> findAllByGradeAndLanguage(Grade grade, Language language);

}
