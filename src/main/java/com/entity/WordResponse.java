package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
