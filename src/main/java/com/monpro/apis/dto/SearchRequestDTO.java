package com.monpro.apis.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SearchRequestDTO {
    @NotNull
    private String query;

    private String sort;

    private String order = "ascending";

    private Integer page = 1;

    private Integer resultsPerPage = 10;
}
