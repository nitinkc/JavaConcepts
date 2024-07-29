package nitin.virtualThreads;

import lombok.*;

/*  Do we need to make this class Thread safe */
@Getter @Setter
@ToString @AllArgsConstructor
@Builder
public class Student {
    private String name;
}