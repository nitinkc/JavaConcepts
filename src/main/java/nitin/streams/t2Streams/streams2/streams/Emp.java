package nitin.streams.t2Streams.streams2.streams;

public class Emp {
  private String firstName, lastName, office;

  public Emp(String firstName, String lastName, String office) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.office = office;
  }

  public String getFirstName() {
    return(firstName);
  }

  public String getLastName() {
    return(lastName);
  }

  public String getOffice() {
    return(office);
  }
  
  @Override
  public String toString() {
    return(String.format("%s %s [%s]", 
           firstName, lastName, office));
  }
}
