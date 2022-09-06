package com.converter.db2Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataDto {
    private String createReleaseNumber;
    private RefTable refData;

}
