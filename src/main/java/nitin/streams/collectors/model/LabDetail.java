package nitin.streams.collectors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabDetail {

    @JsonProperty("name")
    private String name;

    @JsonProperty("uom")
    private String uom;

    private int sortOrder;

    @JsonProperty("labs")
    private List<Lab> labs; // Keeps 13 months of similar labs
}
