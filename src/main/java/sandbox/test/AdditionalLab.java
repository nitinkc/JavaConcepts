
package sandbox.test;

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
public class AdditionalLab {

    @JsonProperty("careCategoryName")
    public String careCategoryName;
    @JsonProperty("lab_test_code")
    public String labTestCode;
    @JsonProperty("name")
    public String name;
    @JsonProperty("uom")
    public String uom;
    @JsonProperty("drawDate")
    public String drawDate;
    @JsonProperty("drawDateDt")
    public String drawDateDt;

    @JsonProperty("drawDatelocaltzdt")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime drawDatelocaltzdt;

    @JsonProperty("davitaLabFlag")
    public Object davitaLabFlag;
    @JsonProperty("value")
    public String value;
    @JsonProperty("outOfRangeInd")
    public Object outOfRangeInd;

}
