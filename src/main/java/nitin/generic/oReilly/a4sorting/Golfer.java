package nitin.generic.oReilly.a4sorting;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Golfer implements Comparable<Golfer> {
  private String first;
  private String last;
  private int score;

  @Override
  public int compareTo(Golfer golfer) {
    return score - golfer.score;
  }
}
