package com.geekbrains.book.store.entities;

import com.geekbrains.book.store.utils.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
