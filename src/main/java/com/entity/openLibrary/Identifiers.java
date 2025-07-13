package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amazon",
    "google",
    "librarything",
    "goodreads",
    "isbn_10",
    "isbn_13",
    "lccn",
    "oclc",
    "openlibrary"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Identifiers {

    @JsonProperty("amazon")
    public List<String> amazon = null;

    @JsonProperty("google")
    public List<String> google = null;

    @JsonProperty("librarything")
    public List<String> librarything = null;

    @JsonProperty("goodreads")
    public List<String> goodreads = null;

    @JsonProperty("isbn_10")
    public List<String> isbn10 = null;

    @JsonProperty("isbn_13")
    public List<String> isbn13 = null;

    @JsonProperty("lccn")
    public List<String> lccn = null;

    @JsonProperty("oclc")
    public List<String> oclc = null;

    @JsonProperty("openlibrary")
    public List<String> openlibrary = null;
}
