package com.monpro.apis.service;

import com.monpro.apis.dto.SearchRequestDTO;
import com.monpro.apis.dto.SearchResultDTO;

import java.util.List;

public interface SearchService {
    List<SearchResultDTO> performSearch(SearchRequestDTO searchRequest);
}
