package com.rogov.labrary.service;


import com.rogov.labrary.dao.BookDAO;
import com.rogov.labrary.dto.BookDTO;
import com.rogov.labrary.dto.OptionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public String getCsvBooks(OptionFilter filter) {

        return bookDAO.getBooks(filter).stream().map(BookService::toCsv).collect(Collectors.joining(","));
    }

    private static String toCsv(BookDTO bookDTO) {
        return bookDTO.getName() + "," +
                bookDTO.getCreationYear() + "," +
                bookDTO.getGenre() + "," +
                bookDTO.getAuthor();
    }
}
