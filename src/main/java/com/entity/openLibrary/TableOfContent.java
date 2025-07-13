package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"level", "label", "title", "pagenum"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableOfContent {

    @JsonProperty("level")
    public Integer level;

    @JsonProperty("label")
    public String label;

    @JsonProperty("title")
    public String title;

    @JsonProperty("pagenum")
    public String pagenum;
}
