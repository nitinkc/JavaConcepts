package java11.test;

import java.util.Optional;

public class Testing {
    public static void main(String[] args) {
        System.out.println(getProviderFullNameWithNpiClinicalDoc("Chaurasia, Nitin, Kumar, MD, 12345, Indore, MP"));
        System.out.println(getProviderFullNameWithNpiClinicalDoc("Marathe, Raghu, , MD, 6789, null, null"));
    }

    private static String getProviderFullNameWithNpiClinicalDoc(String str) {
        String[] spannerOrderProvider = str.split(",");

        final StringBuilder fullNameBuilder = new StringBuilder()
                .append(Optional.ofNullable(spannerOrderProvider[0]).orElse(""))
                .append(", ")
                .append(Optional.ofNullable(spannerOrderProvider[1]).orElse(""))
                .append(Optional.ofNullable(spannerOrderProvider[2]).map(name -> " " + name + ".").orElse(" "))
                .append(Optional.ofNullable(spannerOrderProvider[3]).orElse(""))
                .append(" (")
                .append(Optional.ofNullable(spannerOrderProvider[4]).orElse(""))
                .append(")")
                .append(", ")
                .append(Optional.ofNullable(null).isPresent()? ", CityNAme":""  );

        return fullNameBuilder.toString();
    }
}
