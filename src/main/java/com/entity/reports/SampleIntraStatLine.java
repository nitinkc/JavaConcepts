package com.entity.reports;

import java.util.Arrays;
import java.util.Collections;

public class SampleIntraStatLine {
    public static IntraStatsLine getIntraStatsLine() {
        EventComments eventComments =
                EventComments.builder()
                        .facilityId("11019")
                        .orderId("5b571d0a-1124-45b2-9985-373799d97a96")
                        .sectionName(null)
                        .someStats(
                                Collections.singletonList(
                                        SomeStats.builder()
                                                .eventType("Initial Entry")
                                                .eventid("1")
                                                .eventsComments(
                                                        "09:17 EDT Initial Entry Joe, Dow RM")
                                                .timeDtDisplay("09:17")
                                                .build()))
                        .someClass(
                                SomeClass.builder()
                                        .index(101)
                                        .noOfYears(5)
                                        .someStr("one O one")
                                        .build())
                        .build();

        EventComments eventComments2 =
                EventComments.builder()
                        .facilityId("11019")
                        .orderId("5b571d0a-1124-45b2-9985-373799d97a96")
                        .sectionName(null)
                        .someStats(
                                Collections.singletonList(
                                        SomeStats.builder()
                                                .eventType("Updated by")
                                                .eventid("2")
                                                .eventsComments("09:19 EDT Updated by Joe, Dow RM")
                                                .timeDtDisplay("09:19")
                                                .build()))
                        .someClass(
                                SomeClass.builder()
                                        .index(201)
                                        .noOfYears(9)
                                        .someStr("Two O one")
                                        .build())
                        .build();

        IntraStatsLine intraStatsLine =
                IntraStatsLine.builder()
                        .eventComments(Arrays.asList(eventComments, eventComments2))
                        .varianceCount("9")
                        .build();
        return (intraStatsLine);
    }
}
