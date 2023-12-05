package com.monpro.apis.controller;

import com.monpro.apis.dto.SearchRequestDTO;
import com.monpro.apis.dto.SearchResponseDTO;
import com.monpro.apis.dto.SearchResultDTO;
import com.monpro.apis.service.SearchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchControllerTest {
    @Mock
    private SearchService searchService;

    @InjectMocks
    private SearchController searchController;

    @Test
    public void testSearch() {

        // Mocking the searchService
        List<SearchResultDTO> mockResults = Collections.singletonList(SearchResultDTO.builder().build());
        when(searchService.performSearch(any()))
                .thenReturn(mockResults);

        // Prepare a sample SearchRequestDTO
        SearchRequestDTO requestDTO = new SearchRequestDTO();
        requestDTO.setQuery("sample_query");
        requestDTO.setPage(1);
        requestDTO.setResultsPerPage(10);

        // Call the controller method
        SearchResponseDTO response = searchController.search(requestDTO);

        // Assertions
        assertEquals("sample_query", response.getQuery());
        assertEquals(1, response.getPageNumber());
        assertEquals(1, response.getCount());
        assertEquals(mockResults, response.getResults());
    }
}
