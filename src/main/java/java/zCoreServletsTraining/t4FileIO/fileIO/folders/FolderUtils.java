package java.zCoreServletsTraining.t4FileIO.fileIO.folders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/** Some Stream-based static methods for using with folders and paths. */

public class FolderUtils {
  public static void printAllPaths(Stream<Path> paths) {
    paths.forEach(System.out::println);
  }
  
  public static void printAllPathsInFolder(String folder) {
    try(Stream<Path> paths = Files.list(Paths.get(folder))) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printPaths(Stream<Path> paths, Predicate<Path> test) {
    paths.filter(test)
         .forEach(System.out::println);
  }
  
  public static void printPathsInFolder(String folder, Predicate<Path> test) {
    try(Stream<Path> paths = Files.list(Paths.get(folder))) {
      printPaths(paths, test);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printAllPathsInTree(String rootFolder) {
    try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printPathsInTree(String rootFolder, Predicate<Path> test) {
    try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
      printPaths(paths, test);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void findPathsInTree(String rootFolder, BiPredicate<Path,BasicFileAttributes> test) {
    try(Stream<Path> paths = Files.find(Paths.get(rootFolder), 10, test)) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  private FolderUtils() {} // Uninstantiatable class
}
