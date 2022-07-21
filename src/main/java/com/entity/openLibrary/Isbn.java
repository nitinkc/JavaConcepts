
package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "key",
    "title",
    "authors",
    "number_of_pages",
    "identifiers",
    "classifications",
    "publishers",
    "publish_date",
    "subjects"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @JsonProperty("identifiers")
    public Identifiers identifiers;
    @JsonProperty("classifications")
    public Classifications classifications;
    @JsonProperty("publishers")
    public List<Publisher> publishers = null;
    @JsonProperty("publish_date")
    public String publishDate;
    @JsonProperty("subjects")
    public List<Subject> subjects = null;

}
