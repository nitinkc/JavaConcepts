package java.LambdaExpressions.t1Lambdas.lambdas1.actionlistener;

import javax.swing.*;
import java.awt.*;

public abstract class JFrameBase extends JFrame {
  private static final long serialVersionUID = 1L;
  protected Container contentPane;
  protected JButton button1, button2, button3;
  
  public JFrameBase(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    LafUtils.SetNimbusLaf();
    setSize(400, 300);
    contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());
    contentPane.setBackground(Color.LIGHT_GRAY);
    button1 = new JButton("Blue");
    contentPane.add(button1);
    button2 = new JButton("Green");
    contentPane.add(button2);
    button3 = new JButton("Red");
    contentPane.add(button3);
  }
  
  protected void setBg(Color bgColor) {
    contentPane.setBackground(bgColor);
  }
}
