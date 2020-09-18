Java is a strongly statically typed language, and the lambda expression seems to lack type information.

This is how it gets resolved

The first possibility is by assignment to a variable. 
```java
  private static final CarRunner1.CarCriteria1 RED_CAR_CRITERION =  c ->  c.getColor().equals("Red");
```

Another possibility is that we actually pass a lambda expression as an argument to another function call.
 
And in that case, there is an implied assignment to the actual parameter of that method call, 
and that parameter's type specifies what the lambda expression has to be. 
```java
    showAll(getCarsByCriteria1(cars, c -> c.getPassengers().size() == 2));
```

A third possibility, which we haven't used yet, is that we can return a lambda expression directly from a function call. 
If we do that, then the return type declared for that function specifies what the lambda expression must be.

```java
  private static CarRunner1.CarCriteria1 getFourPassengerCriterion(){
    return car -> car.getPassengers().size() == 4;
  }
```