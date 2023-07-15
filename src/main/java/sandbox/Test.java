package sandbox;

import org.apache.commons.lang3.BooleanUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> requestEntity = new HashMap<>();
        requestEntity.put("isMostRecent",123);
        if(requestEntity.get("isMostRecent") instanceof String){
            //Takes care of true, True, Y,Yes etc
            BooleanUtils.toBoolean((String) requestEntity.get("isMostRecent"));
            System.out.println("String");
        }else {
            Class c = requestEntity.get("isMostRecent").getClass();
            System.out.println("not String but " + c);
        }
    }
}
