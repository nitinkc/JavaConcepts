Mainly for memory management

blocks, variables, methods & nested class (inner class)

Static belong to class NOT to the instance (object)


Static Variable : gets memory only once in the class area at the TIME OF LOADING

Static Methods : Invoked without creating instance (Math.pow())

can access static data member

Inheritance only parent visible

Static methods Restrictions

  * Cannot use non static data fielf or method directly
  * Cannot use this and super on the static context
  
Static Initialization Blocks

Runs First, at class loading.

Can have as many blocks as possible 