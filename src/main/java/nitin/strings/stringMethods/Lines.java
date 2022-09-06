package nitin.strings.stringMethods;

import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia
 * Created on Sunday, December/20/2020 at 7:14 PM
 */

public class Lines {
    public static void main(String[] args) throws Exception {

        String str = "line1\nline2\nline3\tline4\rline5";

        System.out.println(
                str.lines()
                        .collect(Collectors.toList())
        );
    }
}
