package java11.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Student {
    //instance member variables
    private String Name;
    private int Age;
}
