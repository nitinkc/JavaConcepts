package java.zOReiley2020SimonRoberts;

import java.util.Arrays;
import java.util.List;

public class StreamVersion {

  public static void main(String[] args) {
    List<String> strings = Arrays.asList(
        "LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen");
    
    strings
        .stream()
        .forEach(s -> System.out.println(s));
    
    System.out.println("Long: ------------------------");
    strings
        .stream()
        .filter(s -> s.length() > 4)
        .forEach(s -> System.out.println(s));
    
    System.out.println("Original: ------------------------");
    strings
        .stream()
        .forEach(s -> System.out.println(s));

    System.out.println("SHOUTING: ------------------------");
    strings
        .stream()
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    
    System.out.println("Short shouting: ------------------------");
    strings
        .stream()
        .filter(s -> s.length() < 6)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    
    List<Car> fleet = Arrays.asList(
        Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
        Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
        Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
        Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
        Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
    );
    
    System.out.println("Drivers with lots of fuel-------------------");
    fleet
        .stream()
        .filter(c -> c.getGasLevel() > 6)
        .map(c -> c.getPassengers().get(0) + " is driving a " + c.getColor() + " car with lots of fuel")
        .forEach(m -> System.out.println(m));

    System.out.println("Add fuel to the tanks-------------------");
    fleet
        .stream()
        .map(c -> c.addGas(5))
        .forEach(c -> System.out.println(c));

    System.out.println("Original cars-------------------");
    fleet
        .stream()
        .forEach(c -> System.out.println(c));

    System.out.println("Passengers in cars with lots of fuel-------------------");
    fleet
        .stream()
        .filter(c -> c.getGasLevel() > 6)
        .flatMap(c -> c.getPassengers().stream())
        .forEach(m -> System.out.println(m));

    System.out.println("Passengers in cars with lots of fuel-------------------");
    fleet
        .stream()
        .filter(c -> c.getGasLevel() > 6)
        .flatMap(c -> 
            c.getPassengers().stream()
            .map(p -> p + " is in a " + c.getColor() + " car with lots of fuel"))
        .forEach(m -> System.out.println(m));
  }
}
