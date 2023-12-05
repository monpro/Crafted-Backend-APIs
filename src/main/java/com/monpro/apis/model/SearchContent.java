package com.monpro.apis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "search_content")
public class SearchContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 1000)
    private String title;
    @Column(name = "link", length = 1000)
    private String link;

    public SearchContent(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public SearchContent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
