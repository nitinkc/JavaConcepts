package nitin.streams.collectors.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TestBaseData {

    @JsonProperty("categoryName")
    private String careCategoryName;
    @JsonProperty("groupName")
    public String groupName;
    @JsonProperty("code")
    public String code;
    @JsonProperty("name")
    public String name;
    @JsonProperty("dateTime")
    public String dateTime;
    @JsonProperty("value")
    public String value;

}