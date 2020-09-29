package com.nitin.zOReiley2020SimonRoberts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {

  private static final Pattern WORD_BREAK = Pattern.compile("\\W+");
  private static final Comparator<Map.Entry<String, Long>> valueOrder
      = Map.Entry.comparingByValue();

  public static Optional<Stream<String>> lines(Path p) {
    try {
      return Optional.of(Files.lines(p));
    } catch (IOException ioe) {
      return Optional.empty();
    }
  }
  
  public static void main(String[] args) throws IOException {
    List<String> filenames = Arrays.asList("PrideAndPrejudice.txt", "Bad.txt", "Emma.txt", "SenseAndSensibility.txt");
    filenames.stream()
        .map(Paths::get)
//        .flatMap(Files::lines)
//        .map(Concordance::lines)
//        .peek(s -> {if (!s.isPresent()) System.err.println("Bad file");})
//        .filter(Optional::isPresent)
//        .flatMap(Optional::get)
        .map(Either.wrap(Files::lines))
        .peek(e -> e.handle(System.err::println))
        .filter(Either::succeeded)
        .flatMap(Either::getValue)
        .map(String::toLowerCase)
        .flatMap(WORD_BREAK::splitAsStream)
        .filter(s -> s.length() > 0)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .sorted(valueOrder.reversed())
        .limit(200)
        .map(e -> String.format("%20s : %5d", e.getKey(), e.getValue()))
        .forEach(System.out::println);
  }
}

