
package com.entity.gutendex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text/plain; charset=us-ascii",
    "application/x-mobipocket-ebook",
    "application/rdf+xml",
    "application/epub+zip",
    "text/plain",
    "text/html; charset=iso-8859-1",
    "text/html",
    "application/zip",
    "image/jpeg",
    "text/plain; charset=iso-8859-1",
    "text/html; charset=us-ascii",
    "text/plain; charset=utf-8",
    "text/html; charset=utf-8",
    "audio/mpeg",
    "audio/mp4",
    "audio/ogg"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Formats {

    @JsonProperty("text/plain; charset=us-ascii")
    public String textPlainCharsetUsAscii;
    @JsonProperty("application/x-mobipocket-ebook")
    public String applicationXMobipocketEbook;
    @JsonProperty("application/rdf+xml")
    public String applicationRdfXml;
    @JsonProperty("application/epub+zip")
    public String applicationEpubZip;
    @JsonProperty("text/plain")
    public String textPlain;
    @JsonProperty("text/html; charset=iso-8859-1")
    public String textHtmlCharsetIso88591;
    @JsonProperty("text/html")
    public String textHtml;
    @JsonProperty("application/zip")
    public String applicationZip;
    @JsonProperty("image/jpeg")
    public String imageJpeg;
    @JsonProperty("text/plain; charset=iso-8859-1")
    public String textPlainCharsetIso88591;
    @JsonProperty("text/html; charset=us-ascii")
    public String textHtmlCharsetUsAscii;
    @JsonProperty("text/plain; charset=utf-8")
    public String textPlainCharsetUtf8;
    @JsonProperty("text/html; charset=utf-8")
    public String textHtmlCharsetUtf8;
    @JsonProperty("audio/mpeg")
    public String audioMpeg;
    @JsonProperty("audio/mp4")
    public String audioMp4;
    @JsonProperty("audio/ogg")
    public String audioOgg;

}
