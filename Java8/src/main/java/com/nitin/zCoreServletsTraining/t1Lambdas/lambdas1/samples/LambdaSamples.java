package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.samples;

import com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.integrable.*;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import javax.swing.*;

public class LambdaSamples {
  private final String[] testStrings = {"one", "two", "three", "four"};
  private final JButton someButton = new JButton("Click Me");
  private final ExecutorService taskList = Executors.newFixedThreadPool(100);
  
  @SuppressWarnings({"unused", "resource"}) // Just showing lambda syntax with no real functionality
  public void doSomeLambdas() {
    Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
    taskList.execute(() -> downloadSomeFile());
    someButton.addActionListener(event -> handleButtonClick());
    double d = MathUtilities.integrate(x -> x*x, 0, 100, 1000);
    AutoCloseable c = () -> cleanupForTryWithResources();
    Thread.UncaughtExceptionHandler handler = (thread, exception) -> doSomethingAboutException();
    Formattable f = (formatter, flags, width, precision) -> makeFormattedString();
    ContentHandlerFactory fact = mimeType -> createContentHandlerForMimeType();
    CookiePolicy policy = (uri, cookie) -> decideIfCookieShouldBeAccepted();
    Flushable toilet = () -> writeBufferedOutputToStream();
    TextListener t = event -> respondToChangeInTextValue();
  }
  
  private void downloadSomeFile() {}
  private void handleButtonClick() {}
  private void cleanupForTryWithResources() {}
  private void doSomethingAboutException() {}
  private void makeFormattedString() {}
  private ContentHandler createContentHandlerForMimeType() { return(null); }
  private boolean decideIfCookieShouldBeAccepted() { return(false); }
  private void writeBufferedOutputToStream() {}
  private void respondToChangeInTextValue() {}
}
