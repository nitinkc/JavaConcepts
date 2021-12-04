package java11.test;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.parser.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        String strTemp = "{createddatetime:1619018633187,createdsessiontokenid:'000650KZl1lfKzLjzcqenbsbmQPc',lastupdateddatetime:1619021567333,updatedsessiontokenid:'0006UQi2FooBgW8xxHVf1xbayyGY',userfirstname:'Abel',userlastname:'Flores',username:'ABFLORES',userroles:'CLM'}";

        String str = strTemp.substring(1,strTemp.length()-1);
        String[] tokens = str.split(",");
        Model model = new Model();
        model.setCreateddatetime(tokens[0].split(":")[1]);
        model.setCreatedsessiontokenid(StringUtils.strip(tokens[1].split(":")[1],"'"));
        model.setLastupdateddatetime(tokens[2].split(":")[1]);
        model.setUpdatedsessiontokenid(StringUtils.strip(tokens[3].split(":")[1],"'"));
        model.setUserfirstname(StringUtils.strip(tokens[4].split(":")[1],"'"));
        model.setUserlastname(StringUtils.strip(tokens[5].split(":")[1],"'"));
        model.setUserroles(StringUtils.strip(tokens[6].split(":")[1],"'"));
        model.setUserroles(StringUtils.strip(tokens[7].split(":")[1],"'"));

        System.out.println(model);
    }
}
