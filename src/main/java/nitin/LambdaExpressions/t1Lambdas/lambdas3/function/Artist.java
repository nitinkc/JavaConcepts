package nitin.LambdaExpressions.t1Lambdas.lambdas3.function;

public class Artist extends Person {
    private ArtType artType = ArtType.PAINTING;

    public ArtType getArtType() {
        return (artType);
    }

    public void setArtType(ArtType artType) {
        this.artType = artType;
    }

    public enum ArtType {PAINTING, SCULPTING, TERRAFORMING}
}
