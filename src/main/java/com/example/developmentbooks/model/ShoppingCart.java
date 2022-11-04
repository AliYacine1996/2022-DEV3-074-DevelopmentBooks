package com.example.developmentbooks.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCart {

    @Id
    private String bookId;
    private Integer count;



}
