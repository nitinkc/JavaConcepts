there are some common or recurring patterns that show up in lambda expressions.

In one case, a lambda expression will often take some arguments and invoke a 
static method on a class passing exactly the arguments to the lambda 
expression, directly to the method arguments of that static method. 

Another case takes the lambda arguments and passes them completely intact to a method that is invoked on an object. A third case gain takes the lambdas arguments and passes them to a constructor. And another format will take the first argument from the lambda, and use that to invoke a method. The remaining arguments from the lambda are then passed as the method arguments to that invocation. And it turns out that when we have any one of these four forms but notice it must be exactly these four forms we don't get to reorder the arguments or anything like that


