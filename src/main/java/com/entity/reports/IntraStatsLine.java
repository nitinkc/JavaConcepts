package com.entity.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.*;

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
