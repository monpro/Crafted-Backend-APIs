package com.monpro.apis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchResultDTO {
    private long id;
    private String queryTitle;
    private String link;
}