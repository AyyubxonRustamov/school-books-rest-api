package com.example.maktabdarsliklari.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private String name;
    private String description;
    private int grade;
    private String authors;
    private String language;
}
