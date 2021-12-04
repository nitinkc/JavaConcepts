package java8.zCoreServletsTraining.t1Lambdas.lambdas1.actionlistener;

import java.awt.*;

/** The third of a series of examples that look at different
 *  ways to set up a button handler, which must be an instance
 *  of a class that implements ActionListener.
 *  Example 1: named inner classes 
 *  Example 2: anonymous inner classes 
 *  Example 3: lambda expressions (this example)
 *  Example 4: lambda expressions that refer to effectively final
 *             local variables.
 */
public class ButtonFrame3 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame3() {
    super("Lambdas");
    button1.addActionListener(event -> setBg(Color.BLUE));  // Notice omitting parens since there is exactly one parameter
    button2.addActionListener(event -> setBg(Color.GREEN));
    button3.addActionListener(event -> setBg(Color.RED));
    setVisible(true);
  } 
}
