package sandbox.puzzles;

public class zJavaPuzzles {
  static void main(){
    int x = 10;
    modify(x);
    System.out.println(x);
  }

  private static void modify(int x){
    x += 5;
  }
}
