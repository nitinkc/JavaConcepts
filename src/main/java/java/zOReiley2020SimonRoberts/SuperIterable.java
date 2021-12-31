package java.zOReiley2020SimonRoberts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;
  
  public SuperIterable(Iterable<E> toWrap) {
    self = toWrap;
  }
  
  public SuperIterable<E> filter(Predicate<E> pred) {
    List<E> rv = new ArrayList<>();
    
    for (E e : self) {
      if (pred.test(e)) {
        rv.add(e);
      }
    }
    return new SuperIterable<>(rv);
  }
  
  public <F> SuperIterable<F> map(Function<E, F> op) {
    List<F> rv = new ArrayList<>();
    self.forEach(e -> rv.add(op.apply(e)));
    return new SuperIterable<>(rv);
  }
  
  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    List<F> rv = new ArrayList<>();
    self.forEach(e -> op.apply(e).forEach(f -> rv.add(f)));
    return new SuperIterable<>(rv);
  }
  
  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }
  
  public static void main(String[] args) {
    SuperIterable<String> strings = new SuperIterable<>(Arrays.asList(
        "LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen"));
    
    strings.forEach(s -> System.out.println(s));
    
    System.out.println("Long: ------------------------");
    strings
        .filter(s -> s.length() > 4)
        .forEach(s -> System.out.println(s));
    
    System.out.println("Original: ------------------------");
    strings.forEach(s -> System.out.println(s));

    System.out.println("SHOUTING: ------------------------");
    strings
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    
    System.out.println("Short shouting: ------------------------");
    strings
        .filter(s -> s.length() < 6)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    
    SuperIterable<Car> fleet = new SuperIterable<>(Arrays.asList(
        Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
        Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
        Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
        Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
        Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
    ));
    
    System.out.println("Drivers with lots of fuel-------------------");
    fleet
        .filter(c -> c.getGasLevel() > 6)
        .map(c -> c.getPassengers().get(0) + " is driving a " + c.getColor() + " car with lots of fuel")
        .forEach(m -> System.out.println(m));

    System.out.println("Add fuel to the tanks-------------------");
    fleet
        .map(c -> c.addGas(5))
        .forEach(c -> System.out.println(c));

    System.out.println("Original cars-------------------");
    fleet
        .forEach(c -> System.out.println(c));

    System.out.println("Passengers in cars with lots of fuel-------------------");
    fleet
        .filter(c -> c.getGasLevel() > 6)
        .flatMap(c -> new SuperIterable<>(c.getPassengers()))
        .forEach(m -> System.out.println(m));

    System.out.println("Passengers in cars with lots of fuel-------------------");
    fleet
        .filter(c -> c.getGasLevel() > 6)
        .flatMap(c -> 
            new SuperIterable<>(c.getPassengers())
            .map(p -> p + " is in a " + c.getColor() + " car with lots of fuel"))
        .forEach(m -> System.out.println(m));

  }
}
