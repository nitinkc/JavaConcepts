package nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*  Do we need to make this class Thread safe */
@Getter @Setter
@ToString @AllArgsConstructor
public class User {
    private String id;
}