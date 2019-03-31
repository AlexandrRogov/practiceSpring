package com.rogov.labrary.dao;

import com.rogov.labrary.dto.BookDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookDTO> {

    @Override
    public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BookDTO.builder()
                .name(rs.getString("name"))
                .creationYear(rs.getString("creation"))
                .author(rs.getString("author"))
                .genre(rs.getString("genre"))
                .build();

    }
}
