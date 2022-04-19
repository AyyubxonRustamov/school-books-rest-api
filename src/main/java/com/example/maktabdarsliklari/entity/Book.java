package com.example.maktabdarsliklari.entity;

import com.example.maktabdarsliklari.entity.enums.Grade;
import com.example.maktabdarsliklari.entity.enums.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Grade grade = Grade.BIRINCHI;

    @Transient
    private int gradeNumber = grade.getNumber();

    @Enumerated(EnumType.STRING)
    private Language language;

    private String authors;


}
