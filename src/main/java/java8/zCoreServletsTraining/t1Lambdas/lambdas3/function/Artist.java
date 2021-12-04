package java8.zCoreServletsTraining.t1Lambdas.lambdas3.function;

public class Artist extends Person {
  public enum ArtType { PAINTING, SCULPTING, TERRAFORMING };
  private ArtType artType = ArtType.PAINTING;

  public ArtType getArtType() {
    return(artType);
  }

  public void setArtType(ArtType artType) {
    this.artType = artType;
  }
}
