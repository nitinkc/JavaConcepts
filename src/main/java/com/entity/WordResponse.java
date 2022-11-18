package com.entity;

import lombok.*;

/**
 * Created by nitin on Saturday, February/15/2020 at 10:17 PM
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class WordResponse {

    private String word;
    private int score;
    private String[] tags;
}
