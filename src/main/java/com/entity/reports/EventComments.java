package com.entity.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class EventComments implements Payloadable {

    private String facilityId;
    private String orderId;
    private List<SomeStats> someStats;
    private String sectionName;
    private SomeClass someClass;
}
