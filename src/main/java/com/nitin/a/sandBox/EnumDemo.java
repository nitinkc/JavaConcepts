package com.nitin.a.sandBox;

import java.util.Calendar;

  public class EnumDemo {

          public static void main (String [] args) {
              int x = 0, y = 4, z = 5;
              if (x > 0)
                  if (y < 3)
                      System.out.println("One");
                  else if (y < 4)
                      System.out.println("Two");
                  else if (z > 5)
                      System.out.println("Three");
                  else
                      System.out.println("Four");
          }
  }