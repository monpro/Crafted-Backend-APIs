package com.monpro.apis.repository;

import com.monpro.apis.model.SearchContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchContentRepository extends JpaRepository<SearchContent, Long> {
}
