package nitin.generic.oReilly.a4sorting;

import lombok.*;

import java.util.Objects;

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