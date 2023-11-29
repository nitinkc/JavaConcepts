package nitin.zKnowYourJava;

public class T11Records {
    public static void main(String[] args) {
        System.out.println(new Year(23));

    }
}

record Year(int year){
    //Avoid Canonical constructors as much as possible.
    // Use the compact constructor instead
    //Compact constructor is a filter or a pre-processor before the constructor is called.

    //code -->  Compact constructor --> constructor.

    Year {
        if(year < 0){
            throw new RuntimeException("Negative Year");
        }
        if(year < 100){
            //this.year = 2000 + year;
            year = 2000 + year;
        }
    }
}
