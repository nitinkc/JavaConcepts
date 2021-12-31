package java.zCoreServletsTraining.t1Lambdas.lambdas3.function;

public class Consultant extends Person {
  public enum Speciality { COMPUTER_PROGRAMMING, MANAGEMENT_PRACTICES, EXTRATERRESTRIAL_LANGUAGES };
  private Speciality speciality = Speciality.COMPUTER_PROGRAMMING;

  public Speciality getSpeciality() {
    return speciality;
  }

  public void setSpeciality(Speciality speciality) {
    this.speciality = speciality;
  }
}
