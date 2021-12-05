package sandbox.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Model {
    private String createddatetime;
    private String createdsessiontokenid;
    private String lastupdateddatetime;
    private String updatedsessiontokenid;
    private String userfirstname;
    private String userlastname;
    private String username;
    private String userroles;
}
