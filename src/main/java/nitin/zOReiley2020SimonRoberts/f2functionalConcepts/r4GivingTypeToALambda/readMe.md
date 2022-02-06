Java is a strongly statically typed language, and the lambda expression seems to lack type information.

This is how it gets resolved

- The first possibility is by **assignment to a variable**.

```java
private static final CarCriteria1 RED_CAR_CRITERION =  c ->  c.getColor().equals("Red");
```

- **Passing a lambda expression as an argument** to another function call.

There is an implied assignment to the actual parameter of that method call, and that parameter's type specifies what the
lambda expression has to be.

```java
    showAll(getCarsByCriteria1(cars, c -> c.getPassengers().size() == 2));
```

- Third, Returning a lambda expression directly from a function call.

The return type declared for that function specifies what the lambda expression must be.

```java
  private static CarCriteria1 getFourPassengerCriterion(){
    return car -> car.getPassengers().size() == 4;
  }
```

- Fouth, the one that is significantly less common but completely legitimate, is to use a cast to specify what type of
  lambda we're trying to build.

## Standalone Lamdba using Type Casting.≥

So, prior to the advent of lambda expressions in Java 8, there were two kinds of places that you could use a cast.

- You could use a cast on a primitive value which would cause the bit pattern representation to change, perhaps from a
  32 bit integer into a 16 bit integer.

- Or you could use a **cast on an object reference expression** to say, _"Trust me, compiler, I know this looks like
  it's a reference to a car, but actually it's a special kind of car called a very fast car. And I know this, therefore
  I want you to trust that."_

Those two forms of casts are quite different from what's happening now.

``` java
boolean b = ((CarCriteria1)(c -> c.getColor().equals("Red"))).test(Car1.withGasColorPassengers(0,"Red"));
```

This form of cast expression literally decides what will be created in the first place. And is quite different.

Now, notice that a single lambda expression could potentially be compiled into multiple different interfaces depending
on the context.

```java
    boolean b2 = ((Strange)(c -> c.getColor().equals("Red"))).anotherTestStuff(Car1.withGasColorPassengers(0,"Red"));

```

Potentially confusing, and that's one of the reasons that we might choose to put the argument types into the lambda's
formal parameter list. Because that could be sufficient in some cases to resolve that ambiguity. 
