package com.monpro.apis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchResultDTO {
    private long id;

    private String title;
    private String link;
}