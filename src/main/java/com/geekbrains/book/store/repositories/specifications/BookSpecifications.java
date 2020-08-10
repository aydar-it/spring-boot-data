package com.geekbrains.book.store.repositories.specifications;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.utils.Genre;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {
    public static Specification<Book> genreEqual(String genre) {
        Genre genreField;
        switch (genre) {
            case "Детектив":
                genreField = Genre.DETECTIVE;
                break;
            case "Фантастика":
                genreField = Genre.FICTION;
                break;
            case "Фэнтези":
                genreField = Genre.FANTASY;
                break;
            default:
                throw new RuntimeException("Unknown genre");
        };
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("genre"), genreField);
    }
}
