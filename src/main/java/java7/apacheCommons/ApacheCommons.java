package java7.apacheCommons;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ApacheCommons {
    public static void main(String[] args) {
        stringToCurrency();
        compareString();
    }

    private static void compareString() {
        //No exception handling required
        System.out.println(StringUtils.equalsIgnoreCase("Nitin", null));

        //If above Apache commons is not used
        System.out.println("Nitin".equalsIgnoreCase("null"));

        //Null needs be handled
        //System.out.println(null.equalsIgnoreCase("Nitin"));
    }

    private static void stringToCurrency() {
        String[] amt = {"NK","22.7","23","2242523614.45436346"};

        for (String str : amt) {
            if(NumberUtils.isCreatable(str)){
                str = "$" + new java.text.DecimalFormat("#,##0.00").format(Double.parseDouble(str));
                System.out.println(str);
            }

            if(str != null){
                //Number format exception on str="NK"
                //str = "$" + new java.text.DecimalFormat("##0.00").format(Double.parseDouble(str));
                //System.out.println(str);
            }
        }
    }
}
