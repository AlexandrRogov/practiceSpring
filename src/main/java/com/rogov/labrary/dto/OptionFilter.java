package com.rogov.labrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionFilter {

    private List<String> authors;
    private List<String> genres;
    private Integer yearFrom;
    private Integer yearTo;
}
