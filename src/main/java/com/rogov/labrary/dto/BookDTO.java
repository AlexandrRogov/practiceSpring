package com.rogov.labrary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String name;
    private String creationYear;
    private String genre;
    private String author;
}
