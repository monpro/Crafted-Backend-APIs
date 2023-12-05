package com.monpro.apis.controller;

import com.monpro.apis.dto.SearchRequestDTO;
import com.monpro.apis.dto.SearchResponseDTO;
import com.monpro.apis.dto.SearchResultDTO;
import com.monpro.apis.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/v1.0/search")
    public SearchResponseDTO search(SearchRequestDTO searchRequest) {
        List<SearchResultDTO> results = searchService.performSearch(searchRequest);

        return SearchResponseDTO
                .builder()
                .query(searchRequest.getQuery())
                .pageNumber(searchRequest.getPage())
                .count(results.size())
                .results(results)
                .build();
    }
}
