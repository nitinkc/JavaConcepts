package nitin.optionals;

import java.util.Optional;

/** Created by nichaurasia on Friday, May/29/2020 at 1:13 PM */
public class O1ofVsOfNullable {

    /**
     * optional Provides a means for a function returning a value to indicate the value could
     * possibly be null. Optional is a box that contains values in it Optional is of 16 bytes, and
     * is an Object. creates a separate memory, excessive use should be avoided as it can create
     * performance issues.
     *
     * <p>Optional is immutable. Once assigned, it cannot be reassigned.
     */
    public static void main(String[] args) {
        String str = "String";
        // Declaration by Of, Can't take null
        Optional<String> strOptional = Optional.of(str);

        // By Empty Optional, to be used later
        Optional<String> emptyOptional = Optional.empty();

        ofNullable();
    }

    private static void ofNullable() {
        Optional<String> optionalString = Optional.ofNullable(null);
        System.out.println(optionalString); // Optional.empty

        String isBooleanFlag = "true"; // 'undefined', 'false', 'anyStringValue '
        boolean aBoolean = Boolean.parseBoolean(isBooleanFlag);

        // By Nullable : if not sure whether the argument (str) is actually having a value or it's
        // not.
        Optional<String> nullableOptional1 = Optional.ofNullable("str");
        Optional<String> nullableOptional2 = Optional.ofNullable(null);
    }
}
