package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibDto {
    @JsonProperty("title")
    public String title;

    @JsonProperty("number_of_pages")
    public Integer numberOfPages;

    @JsonProperty("weight")
    public String weight;

    @JsonProperty("table_of_contents")
    public List<TableOfContent> tableOfContents = new ArrayList<>();
}
