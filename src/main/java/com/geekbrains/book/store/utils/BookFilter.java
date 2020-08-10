package com.geekbrains.book.store.utils;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.repositories.specifications.BookSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class BookFilter {
    private Specification<Book> spec;

    public BookFilter(Map<String, String> params) {
        spec = Specification.where(null);
        if (params.get("det") != null && !params.get("det").equals("")) {
            spec = spec.or(BookSpecifications.genreEqual("Детектив"));
        }
        if (params.get("fic") != null && !params.get("fic").equals("")) {
            spec = spec.or(BookSpecifications.genreEqual("Фантастика"));
        }
        if (params.get("fan") != null && !params.get("fan").equals("")) {
            spec = spec.or(BookSpecifications.genreEqual("Фэнтези"));
        }
    }
}
