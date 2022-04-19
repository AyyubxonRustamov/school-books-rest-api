package com.example.maktabdarsliklari.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//faylga tegishli bytelarni saqlab turish
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //bitta fayl bitta byte array
    @OneToOne
    Attachment attachment;

    private byte[] bytes;
}
