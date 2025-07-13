package com.entity.gutendex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "authors",
    "translators",
    "subjects",
    "bookshelves",
    "languages",
    "copyright",
    "media_type",
    "formats",
    "download_count"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("authors")
    public List<Author> authors = null;

    @JsonProperty("translators")
    public List<Object> translators = null;

    @JsonProperty("subjects")
    public List<String> subjects = null;

    @JsonProperty("bookshelves")
    public List<String> bookshelves = null;

    @JsonProperty("languages")
    public List<String> languages = null;

    @JsonProperty("copyright")
    public Boolean copyright;

    @JsonProperty("media_type")
    public String mediaType;

    @JsonProperty("formats")
    public Formats formats;

    @JsonProperty("download_count")
    public Integer downloadCount;
}
