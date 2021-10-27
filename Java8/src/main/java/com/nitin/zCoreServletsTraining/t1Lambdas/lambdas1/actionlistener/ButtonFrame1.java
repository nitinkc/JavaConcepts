package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.actionlistener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** The first of a series of examples that look at different
 *  ways to set up a button handler, which must be an instance
 *  of a class that implements ActionListener.
 *  Example 1: named inner classes (this example)
 *  Example 2: anonymous inner classes
 *  Example 3: lambda expressions
 *  Example 4: lambda expressions that refer to effectively final
 *             local variables.
 */
public class ButtonFrame1 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame1() {
    super("Named Inner Classes");
    button1.addActionListener(new ColorChanger(Color.BLUE));
    button2.addActionListener(new ColorChanger(Color.GREEN));
    button3.addActionListener(new ColorChanger(Color.RED));
    setVisible(true);
  }
  
  private class ColorChanger implements ActionListener {
    private Color bgColor;
    
    public ColorChanger(Color bgColor) {
      this.bgColor = bgColor;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
      setBg(bgColor);
    }
  }
}
