### List Interface

```sh
public interface List<E> extends Collection<E>

boolean add(E e)
boolean addAll(Collection<? extends E> c)
boolean containsAll(Collection<?> c)
E get(int index)
```

```sh
public class Collections

public static final <T> List<T> emptyList()
public static final <K,V> Map<K,V> emptyMap()
public static <T> boolean addAll(Collection<? super T> c, T... elements)
public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)
```

## Scope
* ?
* ? extends E
* ? super T
* Wildcards on **Types**
* Wildcards on **methds**

## Generics and Inheritance
String extends Object,

Array of Strings extends Array of Object

BUT

List<String> does **NOT** extend List<Object>

Number is Super class to other Wrapper Classes
![](https://docs.oracle.com/javase/tutorial/figures/java/objects-numberHierarchy.gif)

## Wild cards

* Unbounded - ? 
    * Can be Read, but cannot be written
    
* Upper Bound - ? extends AClass
    * Give a maximum class
    * can be defined and be read from
    * cannot add to, as the data type cannot be resolved to
    * Covarient - preserves the ordering of types from more specific to more general
    * Generic java collections are covarient when extends is used with a wild card
        * this means - if you declare a collection, with a bounded wildcard,
        you can use methods from the Bound (AClass)
        * Eg: ? extends Number, the methods of Number can also be used
    * USING -> List<? extends Number> each element Supports Number methods as well, along with ?

* Lower bound - ? super AClass
    * Bound on the ? is AClass or above        
    

**PECS**  Producer Extends, Consumer Super.

use the extends keyword when we are consuming the value, when there's a value that's coming in that we're going to 
invoke methods on. Whereas we use super when we are providing a value, because then we can provide either the value 
itself or one of its superclass types, and we do an explicit type when we have both an upper and a lower bound.