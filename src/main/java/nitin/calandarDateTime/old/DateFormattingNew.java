package nitin.calandarDateTime.old;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class DateFormattingNew {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss a.SSSX")
    public static Timestamp createDateTimeGmt;

    public static void main(String[] args) {
        createDateTimeGmt = new Timestamp(System.currentTimeMillis());
        System.out.println(createDateTimeGmt);
    }
}
