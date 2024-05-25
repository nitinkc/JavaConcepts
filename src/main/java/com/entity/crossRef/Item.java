package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "indexed",
        "publisher-location",
        "reference-count",
        "publisher",
        "content-domain",
        "published-print",
        "DOI",
        "type",
        "created",
        "source",
        "is-referenced-by-count",
        "title",
        "prefix",
        "author",
        "member",
        "deposited",
        "score",
        "resource",
        "issued",
        "references-count",
        "URL",
        "published",
        "isbn-type",
        "page",
        "published-online",
        "container-title",
        "ISBN",
        "alternative-id",
        "issue",
        "short-container-title",
        "volume",
        "language",
        "subtitle",
        "journal-issue",
        "ISSN",
        "issn-type",
        "subject",
        "reference",
        "link",
        "editor",
        "edition-number",
        "license",
        "abstract",
        "original-title"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("indexed")
    public Indexed indexed;
    @JsonProperty("publisher-location")
    public String publisherLocation;
    @JsonProperty("reference-count")
    public Integer referenceCount;
    @JsonProperty("publisher")
    public String publisher;
    @JsonProperty("content-domain")
    public ContentDomain contentDomain;
    @JsonProperty("published-print")
    public PublishedPrint publishedPrint;
    @JsonProperty("DOI")
    public String doi;
    @JsonProperty("type")
    public String type;
    @JsonProperty("created")
    public Created created;
    @JsonProperty("source")
    public String source;
    @JsonProperty("is-referenced-by-count")
    public Integer isReferencedByCount;
    @JsonProperty("title")
    public List<String> title = null;
    @JsonProperty("prefix")
    public String prefix;
    @JsonProperty("author")
    public List<Author> author = null;
    @JsonProperty("member")
    public String member;
    @JsonProperty("deposited")
    public Deposited deposited;
    @JsonProperty("score")
    public Float score;
    @JsonProperty("resource")
    public Resource resource;
    @JsonProperty("issued")
    public Issued issued;
    @JsonProperty("references-count")
    public Integer referencesCount;
    @JsonProperty("URL")
    public String url;
    @JsonProperty("published")
    public Published published;
    @JsonProperty("isbn-type")
    public List<IsbnType> isbnType = null;
    @JsonProperty("page")
    public String page;
    @JsonProperty("published-online")
    public PublishedOnline publishedOnline;
    @JsonProperty("container-title")
    public List<String> containerTitle = null;
    @JsonProperty("ISBN")
    public List<String> isbn = new ArrayList<>();
    @JsonProperty("alternative-id")
    public List<String> alternativeId = null;
    @JsonProperty("issue")
    public String issue;
    @JsonProperty("short-container-title")
    public List<String> shortContainerTitle = null;
    @JsonProperty("volume")
    public String volume;
    @JsonProperty("language")
    public String language;
    @JsonProperty("subtitle")
    public List<String> subtitle = null;
    @JsonProperty("journal-issue")
    public JournalIssue journalIssue;
    @JsonProperty("ISSN")
    public List<String> issn = null;
    @JsonProperty("issn-type")
    public List<IssnType> issnType = null;
    @JsonProperty("subject")
    public List<String> subject = null;
    @JsonProperty("reference")
    public List<Reference> reference = null;
    @JsonProperty("link")
    public List<Link> link = null;
    @JsonProperty("editor")
    public List<Editor> editor = null;
    @JsonProperty("edition-number")
    public String editionNumber;
    @JsonProperty("license")
    public List<License> license = null;
    @JsonProperty("abstract")
    public String _abstract;
    @JsonProperty("original-title")
    public List<String> originalTitle = null;

}
