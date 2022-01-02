package java.LambdaExpressions.t1Lambdas.lambdas1.actionlistener;

import java.awt.*;

/** The fourth of a series of examples that look at different
 *  ways to set up a button handler, which must be an instance
 *  of a class that implements ActionListener.
 *  Example 1: named inner classes 
 *  Example 2: anonymous inner classes 
 *  Example 3: lambda expressions 
 *  Example 4: lambda expressions that refer to effectively final
 *             local variables. (this example)
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
public class ButtonFrame4 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame4() {
    super("Lambdas");
    button1.addActionListener(event -> contentPane.setBackground(Color.BLUE));
    Color button2Color = Color.GREEN;
    button2.addActionListener(event -> setBg(button2Color));
    button3.addActionListener(event -> setBg(Color.RED));
    setVisible(true);
  } 
}
