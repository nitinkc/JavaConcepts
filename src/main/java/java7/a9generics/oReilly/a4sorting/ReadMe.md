[Comparator.comparing](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)

**Learn how to read JavaDoc**
```java
static <T,U extends Comparable<? super U>>
Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)
```

Accepts a function that extracts a Comparable sort key from a type T, and 
returns a Comparator<T> 
that compares by that sort key.

###Argument of Comparing :

Function<? super T,? extends U> keyExtractor

A function is a functional interface-- that takes a single input argument (**?
 super T**) and returns a single output argument (**? extends U**). 

So the word function really means we're taking an argument in and transforming 
it into something else. 

If the input type and the output type are the same, that still could be a 
function, but they have a special name for that. 
That's an interface called a unary operator. 

Here, the input type is T and the output type is U. 

So again, the idea is, we're using super for T because **we are taking an element 
out of the stream and providing it**, or actually, consuming it. 

And then the output type is a U because **we are generating that value from the 
result**. 

So question mark super T comma question mark extends U is trying to tell us that T
is being extracted from the stream. 
 
And then R or U here is being produced by the function. 

So this is called a key extractor. 

And it's simply asking us to provide a T and a U, or with the wildcard associated with them. 

And then what the comparing method will do is, it will take that key extractor, and it will generate a comparator based on the key extractor.
 
 Now, we actually have some restrictions on T and U that are being used in the function. 
 
 T doesn't have any restrictions on it. You can see the declaration of T right here-- static open angle bracket T comma. 
 
 But U has to extend comparable. And U has to extend comparable because the idea is, 
 is that we are going to transform each element. 
 
 Well, let's say it this way. The function will be used to transform each element in the stream from a T into a U. See, the stream is already a stream of T. And then, the function will be applied to turn each element of type T into an element of type U. T

