package com.monpro.apis.service.impl;

import com.monpro.apis.dto.SearchRequestDTO;
import com.monpro.apis.dto.SearchResultDTO;
import com.monpro.apis.model.SearchContent;
import com.monpro.apis.repository.SearchContentRepository;
import com.monpro.apis.service.SearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements SearchService {

    private final SearchContentRepository searchContentRepository;
    @Autowired
    public ServiceServiceImpl(SearchContentRepository searchContentRepository, ModelMapper modelMapper) {
        this.searchContentRepository = searchContentRepository;
    }


    @Override
    public List<SearchResultDTO> performSearch(SearchRequestDTO searchRequest) {
        Pageable pageable = PageRequest.of(searchRequest.getPage() - 1, searchRequest.getResultsPerPage());
        Page<SearchContent> searchResultPage = searchContentRepository.findAll(pageable);
        return searchResultPage.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private SearchResultDTO convertToDto(SearchContent searchContent) {
        return new SearchResultDTO(searchContent.getId(), searchContent.getTitle(), searchContent.getLink());
    }
}
