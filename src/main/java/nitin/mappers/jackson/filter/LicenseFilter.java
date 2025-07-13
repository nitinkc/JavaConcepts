package nitin.mappers.jackson.filter;

import java.util.regex.Pattern;

public class LicenseFilter {
    private static final Pattern licensePattern = Pattern.compile("^[A-Za-z0-9]+-[0-9]+$");

    @Override
    public boolean equals(Object obj) {
        System.out.println("Invoked LicenseFilter");

        if (obj == null || !(obj instanceof String)) {
            return false;
        }
        // phone must match the regex pattern
        return !licensePattern.matcher(obj.toString()).matches();
    }
}
