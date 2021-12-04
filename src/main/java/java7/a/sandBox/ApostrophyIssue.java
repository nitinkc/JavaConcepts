package java7.a.sandBox;

import org.apache.commons.lang3.StringUtils;

public class ApostrophyIssue {
    public static void main(String[] args) {
        //String selectedRad = "onClick='setSelectedValue(\""+ returnPaymentId + delimiterS + vendorId + delimiterS + eaReturnSummaryCargo.getRequestedBy()+"\")'";
        //String selectedRad = "onClick='setSelectedValue(\""+ returnPaymentId + delimiterS + vendorId + delimiterS + "Eutsler's" +"\")'";

        int var1 = 123;
        String var2 = "Testing's";
        String delimiterS = "~";

        StringUtils.replace(var2, "'", "&rsquo;");

        String selectedRad = "onClick='setSelectedValue(\"" + var1 + delimiterS + var2+"\")'";
        String selectedRadWithApostropy = "onClick='setSelectedValue(\""+ var1 + delimiterS + "Eutsler's" +"\")'";

        System.out.println(selectedRad);

        System.out.println(selectedRadWithApostropy);
    }
}