package nitin.streams.collectors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabBase {

    @JsonProperty("categoryName")
    public String categoryName;
    @JsonProperty("testCodeId")
    public String testCodeId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("uom")
    public String uom;

    @JsonProperty("dateTime")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime dateTime;

    @JsonProperty("value")
    public String value;
    @JsonProperty("sortOrder")
    public int sortOrder;
}
