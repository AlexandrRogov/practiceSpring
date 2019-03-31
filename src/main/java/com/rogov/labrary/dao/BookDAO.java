package com.rogov.labrary.dao;


import com.rogov.labrary.dto.BookDTO;
import com.rogov.labrary.dto.OptionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO {

    private static final String BOOKS_QUERY =
            "SELECT DISTINCT author.name AS author_name, genre.name AS genre_name, book.name AS book_name, book.creation_year FROM book_storage.book book " +
                    "INNER JOIN book_storage.genre genre ON book.genre_id = genre.id " +
                    "INNER JOIN book_storage.author author ON book.author_id = author.id " +
                    "WHERE (author.name IN (:authors)) " +
                    "AND (genre.name IN (:genres)) " +
                    "AND ((:fromYear) IS NULL OR book.creation_year >= :fromYear) " +
                    "AND ((:toYear) IS NULL OR book.creation_year <= :toYear) ";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookDTO> getBooks(OptionFilter filter) {
        return jdbcTemplate.query(BOOKS_QUERY, new BeanPropertySqlParameterSource(filter), new BookRowMapper());
    }
}
