package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"preview_url", "availability", "formats", "borrow_url", "checkedout"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ebook {

    @JsonProperty("preview_url")
    public String previewUrl;

    @JsonProperty("availability")
    public String availability;

    @JsonProperty("formats")
    public Formats formats;

    @JsonProperty("borrow_url")
    public String borrowUrl;

    @JsonProperty("checkedout")
    public Boolean checkedout;
}
