package nitin.mappers.jackson.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.*;
import nitin.mappers.jackson.filter.DateOfBirthFilter;
import nitin.mappers.jackson.filter.EmptyListFilter;
import nitin.mappers.jackson.filter.PhoneFilter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {
    @JsonProperty("name")
    private String name;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = DateOfBirthFilter.class)
    private Date dob;

    @JsonProperty("datelocaltzdt")
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime datelocaltzdt;

    @JsonProperty("phones")
    @JsonInclude(content = JsonInclude.Include.CUSTOM, contentFilter = PhoneFilter.class)
    private Map<String, String> phones;

    @JsonProperty("addresses")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, contentFilter = EmptyListFilter.class)
    // @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Address> addresses;
}
