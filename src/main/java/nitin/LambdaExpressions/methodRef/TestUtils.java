package nitin.LambdaExpressions.methodRef;

public class TestUtils {

    public String getAscii(String str){
        int sum=0;
        for(int i=0; i<str.length(); i++) {
            int asciiValue = str.charAt(i);
            sum = sum+ asciiValue;
        }
        return ("ASCII of " + str + "=" + sum);
    }
}