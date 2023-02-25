package com.entity.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntraStatsLine implements Payloadable {
    List<EventComments> eventComments;
    private String varianceCount;
}