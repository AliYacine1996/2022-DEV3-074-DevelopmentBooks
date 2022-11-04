package com.example.developmentbooks.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String title;
    private String author;
    private String year;
    private Integer price;
    private String imageUrl;


}
