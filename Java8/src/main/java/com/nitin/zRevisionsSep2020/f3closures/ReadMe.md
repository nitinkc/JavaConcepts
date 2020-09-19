# The idea of using arguments to a factory method


- Previously, we've seen the ability to pass behavior as an argument to a function (often as a lambda, but not necessarily,) 

- and we've been returning behavior back from a function, those have been our factories
 
 But so far the behavior we've been returning out of functions has essentially been fixed. 
 
 
 - get gas level car criterion, creates an object, a new gas level criterion, which is actually
  parametrized with a threshold. The gas level criterion class internally has a threshold. 
  
  That value is set as the argument to the constructor
 
 So the test method that we created here actually behaves in a way that depends on the 
 threshold value that is passed in to the constructor
 
 ### Single Argument
  ```java
// Factory for creating GasLevelCarCriterion
public static Criteria<Car1> getGasLevelCarCriterion(int threshold){
    return new GasLevelCarCriterion(threshold);
  }

  private static class GasLevelCarCriterion implements Criteria<Car1> {
    private int threshold;
    public GasLevelCarCriterion(int threshold) {
      this.threshold = threshold;
    }  
```


The value of threshold is shared. It gets copied from the method stack to the object memory stack of the Lambda

 the object that the lambda represents is created, is that the code is copied in there. But also, the value of 
 threshold is duplicated into the object. 
```java
// Factory for creating GasLevelCarCriterion using anonymous inner class. Variable is shared between lambda.
  // Its effectively final. Can be used, but cannot be modified
  public static Criteria<Car1> getGasLevelCarCriterion(int threshold){

    //threshold = threshold + 1;//Variable 'threshold' is accessed from within inner class, needs to be final or effectively final
    return new Criteria<Car1>(){
      @Override
      public boolean test(Car1 car1) {
        return car1.getGasLevel() >= threshold;
      }
    };
  }
```

OR, The same can be written as 

```java
 public static Criteria<Car1> getGasLevelCarCriterionLambda(int threshold){
        return car1 ->  car1.getGasLevel() >= threshold;
  }
```

### Variable Argument

```java
// Factory method to return a criteria of Car based on multiple car color
  
  public static Criteria<Car1> getColorCriteria(String ...colors){
    Set<String> colorSet = new HashSet<>(Arrays.asList(colors));

    return c -> colorSet.contains(c.color);
  }
```

when a function returns another behavior that depends on the arguments to the factory, then we have that closure effect,
 and the values that are used inside the generated behavior must be constants (final or effectively final). 