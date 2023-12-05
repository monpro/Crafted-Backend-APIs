package com.monpro.apis.service.impl;

import com.monpro.apis.dto.SearchRequestDTO;
import com.monpro.apis.dto.SearchResultDTO;
import com.monpro.apis.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements SearchService {
    @Override
    public List<SearchResultDTO> performSearch(SearchRequestDTO searchRequest) {
        int skip = (searchRequest.getPage() - 1) * searchRequest.getResultsPerPage();
        List<SearchResultDTO> results = List.of();
        if (skip < results.size()) {
            int endIndex = Math.min(skip + searchRequest.getResultsPerPage(), results.size());
            return results.subList(skip, endIndex);
        } else {
            return List.of();
        }
    }
}
