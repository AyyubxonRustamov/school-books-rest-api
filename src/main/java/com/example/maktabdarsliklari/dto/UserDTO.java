package com.example.maktabdarsliklari.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String name;
    private String password;
    private String phone;
    private Set<Long> bookIds;
}
