### List Interface

```java
// Example From java.util.Map.Entry<K,V>
public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey();

//Example from java.util.Comparator<T>
public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor)

// From java.util.stream.Collectors
 public static <T, K, D, A, M extends Map<K, D>>
    Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
                                  Supplier<M> mapFactory,
                                  Collector<? super T, A, D> downstream);
```

```java
// Generic Type is declared on Class/Interface
public interface List<E> extends Collection<E>

boolean add(E e)
boolean addAll(Collection<? extends E> c)
boolean containsAll(Collection<?> c)
E get(int index)
```

```java
// Collections Utility Class, Generic Type is not declared on the Class so each method
// has to declare its own Generic return trype
public class Collections

//Here, collections does not declare a type. So if you want to use a generic type, you have to 
//declare it on the method. And in this case, the empty list method is declaring T after the word final, 
// but before the return type. And the return type is list of T.
public static final <T> List<T> emptyList();//<T> between final and List<T>


public static final <K,V> Map<K,V> emptyMap();

public static <T> boolean addAll(Collection<? super T> c, T... elements);

//Return type is simply T
//we're saying that whatever the generic type is it must implement the comparable interface. 
// Because the min method is going to cast all of the elements of the collection to comparable, 
// in order to determine the minimum one. And this is the mechanism you use in order to declare that 
// a generic type has a bound like that. 
public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp);
```

-----

## Scope (Need to understand)
* ?
* ? extends E (Upper Bound)
* ? super T
* Wildcards on **Types**
* Wildcards on **methods**

## But First, WildCards, Generics and Inheritance
String extends Object,

Array of Strings extends Array of Object

BUT
```
List<String> does **NOT** extend List<Object>
```
Number is Super class to other Wrapper Classes
![](https://docs.oracle.com/javase/tutorial/figures/java/objects-numberHierarchy.gif)

## Wild cards

##### Unbounded 
- ? - The idea behind the question mark operator is that when we declare a collection of that type, 
we're saying we don't know what the underlying type is

    * Can **Read** from it, but cannot **write** to it.
    
##### Upper Bound - ? extends AClass
a wildcard allows you to tell the compiler what type you're expecting, and also allows you to 
provide elements that are that type, or subclasses of that type. 

>use the extends keyword and give a maximum class

* Give a maximum class
* can be defined and be read from
* **cannot add to**, as the data type cannot be resolved to
* >Covarience - preserves the ordering of types from more specific to more general
* >Generic java collections are covarient when extends is used with a wild card
     * this means - if you declare a collection, with a bounded wildcard,
        you can use methods from the Bound (AClass in our case)
    * Eg: List<? extends Number>, the methods of Number can also be used along with class of ?.
     Each element Supports Number methods as well, along with ?

##### Lower bound - ? super MyClass

It must be MyClass or above.

Example : forEach as the default method of Java 8.
    * Bound on the ? is AClass or above        
* >Contravariant - preserves the ordering of types from **more general** to **more specific**
* >Generic java collections are Contravariant when **super** is used with a wild card
    

**PECS**  Producer Extends, Consumer Super.

Acronym coined by Joshua Bloch in "Effective Java"

Mnemonic for

- use **extends** keyword when we **consume** the value
    - when there's a value that's coming in that we're going to invoke methods on. 

- use **super** when we **provide** a value, 
    - because then we can provide either the value itself or one of its superclass types.

- use explicit type when we have both an upper and a lower bound.


>So for example, in Java 8 streams, if we're pulling a value from the stream to use, that's super. 
Whereas if we are using the value in the lambda that we're providing, that's extends.