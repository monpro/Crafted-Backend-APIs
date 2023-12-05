package com.monpro.apis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchResponseDTO {
    private String query;
    private int pageNumber;
    private int count;
    private List<SearchResultDTO> results;
}