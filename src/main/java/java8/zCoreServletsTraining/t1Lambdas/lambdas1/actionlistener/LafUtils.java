package java8.zCoreServletsTraining.t1Lambdas.lambdas1.actionlistener;

import javax.swing.*;

public class LafUtils {
  public static void SetNimbusLaf() {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
  }
}
