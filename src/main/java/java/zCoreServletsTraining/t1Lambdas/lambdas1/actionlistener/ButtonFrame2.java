package java.zCoreServletsTraining.t1Lambdas.lambdas1.actionlistener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** The second of a series of examples that look at different
 *  ways to set up a button handler, which must be an instance
 *  of a class that implements ActionListener.
 *  Example 1: named inner classes 
 *  Example 2: anonymous inner classes (this example)
 *  Example 3: lambda expressions
 *  Example 4: lambda expressions that refer to effectively final
 *             local variables.
 */
public class ButtonFrame2 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame2() {
    super("Anonymous Inner Classes");

    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.BLUE);
      }
    });
    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.GREEN);
      }
    });
    button3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.RED);
      }
    });
    setVisible(true);
  } 
}
