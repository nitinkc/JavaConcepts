package com.nitin.a17Streams.fileStreams;

import lombok.*;

/**
 * Created by nichaurasia on Wednesday, January/29/2020 at 6:24 PM
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cancer {
    private String state;//0
    private String cancer_sites;
    private int Year;//2
    private String sex;
    private String race;//2
    private float count;//5
    private int population;
    private float age_adj_Rate;
}
