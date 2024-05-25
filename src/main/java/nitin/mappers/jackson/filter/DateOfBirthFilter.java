package nitin.mappers.jackson.filter;

import java.util.Date;

public class DateOfBirthFilter {

    @Override
    public boolean equals(Object obj) {
        System.out.println("Invoked DateOfBirthFilter");

        if (obj == null || !(obj instanceof Date date)) {
            return false;
        }
        //date should be in the past
        return date.before(new Date());
    }
}