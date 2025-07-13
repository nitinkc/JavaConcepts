package com.converter.dtoConverter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entity {
    private String idEntity;
    private String someString;
    private String ssn; // PII: Can't be send via Dto
    private Integer age; // PII: Can't be send via Dto
}
