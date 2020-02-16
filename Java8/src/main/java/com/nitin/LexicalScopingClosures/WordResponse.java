package com.nitin.LexicalScopingClosures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Created by nitin on Saturday, February/15/2020 at 10:17 PM
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordResponse {

    private String word;
    private int score;
    private String[] tags;
}
