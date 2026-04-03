package sandbox;

public class TestLambda implements Runnable{

  @Override
  public void run() {
    System.out.println("Running in a thread = " + Thread.currentThread().getName());
  }


}
