package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Isbn {

    @JsonProperty("url")
    public String url;
    @JsonProperty("key")
    public String key;
    @JsonProperty("title")
    public String title;
    @JsonProperty("authors")
    public List<Author> authors = null;
    @JsonProperty("number_of_pages")
    public Integer numberOfPages;
    @JsonProperty("pagination")
    public String pagination;
    @JsonProperty("weight")
    public String weight;
    @JsonProperty("by_statement")
    public String byStatement;
    @JsonProperty("identifiers")
    public Identifiers identifiers;
    @JsonProperty("classifications")
    public Classifications classifications;
    @JsonProperty("publishers")
    public List<Publisher> publishers = null;
    @JsonProperty("publish_places")
    public List<PublishPlace> publishPlaces = null;
    @JsonProperty("publish_date")
    public String publishDate;
    @JsonProperty("subjects")
    public List<Subject> subjects = null;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("table_of_contents")
    public List<TableOfContent> tableOfContents = null;
    @JsonProperty("links")
    public List<Link> links = null;
    @JsonProperty("ebooks")
    public List<Ebook> ebooks = null;
    @JsonProperty("cover")
    public Cover cover;

}
