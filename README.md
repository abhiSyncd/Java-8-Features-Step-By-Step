##
# 1 - @Functional Interfaces | java.util.function package

  ## (1-a) What is a Functional Interfaces

    A special kind of interfaces that contains ONLY-ONE-ABSTRACT-Method
    Note : it may contain many DEFAULT and STATIC methods

    If an interface is annotated with @FunctionalInterface annotation and 
    someone tries to add another abstract method to the, the compiler will throw an error



  ## (1-b) Use of Functional Interfaces
 
    Used to implement functional programming in Java
    In functional programming, functions can exist outside the scope of an object.
    > We can assign them to a reference variable and 
    > we can also pass them to other methods as a parameter, Ex  
      we can pass a Inbuilt|Custom @Functional-Interfaces as an argument to Stream API's methods such as map,filter,reduce,flatMap. 
      To achieve this, we can use LAMBDA Expression, 
      to instantiate @Functional Interfaces inside Stream API functions and avoid using bulky anonymous class implementation
	       
    E.x) [Refer](https://github.com/abhiSyncd/Java-Threads-Step-By-Step) : 
        Creating Threads Using "Anonymous Inner Class" | Functional-Interface+Lammbda
   
   
  ## (1-c) Java 8 In Built @Functional Interfaces
          
    -> Consumer   : Has a method 'accept()' : that accepts one argument and returns no result  
    -> Function   : Has a method 'apply()'  : that accepts one argument and returns an object.  
    -> Predicate  : Has a method 'test()'   : that accepts one argument and returns Boolean result.  
    -> Supplier   : Has a method 'get()'    : that accepts no  argument and returns an object.  
    -> BiConsumer : Has a method 'accept()' : that takes in two arguments and produces a result.  

    For more Java 8 In Built @Functional Interfaces : https://javaconceptoftheday.com/java-8-functional-interfaces/

    Note : @Functional Interfaces Before Java 8 in java.util
    Runnbale Interface :  Has a method 'run()' : that accepts no argument and returns no result 
    Callable Interface :  Has a method 'call()' : that accepts no argument and returns An Object 

   
   
##
# 2 - Stream Interface :: java.util.stream package


   ## (2-a) What is Stream Interface
     
    Provide common operations from functional programing languages on collections,arrays or I/O resources,
    such as :
    -> forEach(Consumer Interface)       : Iterating Collection
    -> map(Function Interface)           : Transforming Collection
    -> filter(Predicate Interface)       : Filtering Collection  
    -> reduce(BiFunction Interface)      : Reducing Collection to a single value(sum or max value in List)
    -> flatmap(Function Interface)       : Flattening (Merging) multiple Lists into a single list 
    -> collect(Supplier Interface)       : Convert Stream to collection
   
   
   ## (2-b) Types of operations in a stream :: Stream return Type
  
    i) Intermediate operations 
       : return Stream and 
         can be chained
         : Ex : filter(Predicate<T>)
		map(Function<T>)
		flatmap(Function<T>)
		sorted(Comparator<T>)
		peek(Consumer<T>)
		distinct()
		limit(long n)
		skip(long n)
			
     ii) Terminal operations 
        : returns a non-stream result (such as primitive value, a collection or no value at all) and 
           cannot be chained
        : Ex :  forEach
		forEachOrdered
		collect
		toArray
		reduce
		min
		max
		count
		anyMatch
		allMatch
		noneMatch
		findFirst    
		findAny
	

  ## (2-c)  Streams vs Collection
         
    - Streams do not store data
      Collection is a data structure used to store, retrieve, manipulate and write back the data.
      A stream is not a data structure and is not used for storage.
      It takes a data source, such as a collection or IO and performs some operations on the data.
	   
    - Streams are Functional in nature
      An operation on a stream produces a result, but does not modify its source.
      Stream operations are performed in a pipeline (aka intermediate operations) and aren't executed until a terminal operation is encountered.
	   
    - Streams are unbounded 
      Collections have a finite size, streams need not.
 
 
  ## (2-d) Advantage of Streams over loops 
 
    - Streams are a more declarative style provides better Readability.

  
  ## (2-e) Streams : Thread Safety and Immutability 
 
	@) Streams and Thread Safety  : Streams are not Thread Safe  
	   We can actually pass a custom ThreadPool when processing the stream: 
	   created using Fork-Join or Executor-Service

	@) Streams and Immutability : 

	   By default, most Stream API Collectors represent mutable collection strategies — 
	   but what happens if one wants to collect elements to an immutable data structure

	   Before Java 10 : 
	   var unmodifiableList = Stream.of(42)
				  .collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));

	   After Java 10 
	   toUnmodifiableList() , toUnmodifiableMap(), toUnmodifiableSet()
	   var collect = Stream.of(42).collect(Collectors.toUnmodifiableList());


	   For More Info : 
	   https://dzone.com/articles/java-10-immutableunmodifiable-stream-api-collector
	  

## (2-f) Parallel Streams
  
  
##
# 3 - Lambda Expression

     Advantage of Lamda Expression 
    - Hides instantiating a functional interface as an anonymous class inside Stream API functions discussed above and
    - provides an inline implementatin for better readability
        
	
	
##	
# 4 - Default and static methods in Interfaces


   ## (a) Interface Before Java 8  
       
       All methods declared in Interfaces were public and abstract( Only Declaration and No Body i.e no implementation) by default,
       which needs to be overridden when any class implements it.
	
  ## (b) Interface After Java 8
   
       Introduced two more methods in Interfaces,which do not need to overriden in all the class implementing it.
       But only by the classes who needs to implement it.

       Both default and static methods in an Interface can have a BODY (Method Implementation), only difference is

       - default methods : called using object of class that implemented it
       - static methods  : called directly by InterfaceName.staticMethodDefinedInTheInterface()
			 : static methods can't be ovveridden.


       Now, why do we need static methods in interfaces if we already have default methods?

       Suppose you want to provide some implementation in your interface and you don’t want this implementation to be overridden in the implementing class, 
       then you can declare the method as static.
       Its to provide utility methods on interface level without creating the object of the interface.
       
       TO-DO: Refer : https://www.codingame.com/playgrounds/2970/default-and-private-methods-in-interfaces

        
##	
# 5 - Dates in java.time package

     - Before Java 8 : Date date = new Date() :  Wed Apr 10 11:43:38 IST 2019 
	                  Problem with Date class : Is a Mutable class hence it is Not Thread Safe
			  
     - Java 8 and after : 
       -> LocalDate localdate = LocalDate.now();             :  2019-04-10
       -> LocalTime localTime = LocalTime.now();             :  11:43:38.549
       -> LocalDateTime localdateTime = LocalDateTime.now(); :  2019-04-10T11:43:38.549

     In Javascript 
       - new Date()                               : Wed Apr 10 2019 11:54:47 GMT+0530 (India Standard Time)  
       - new Date().toISOString()                 : 2019-04-10T06:24:47.236Z  
       - new Date().toISOString().substring(0,10) : 2019-04-10



##
# 6 - [CompletableFuture in java.util.concurrent package](https://github.com/abhiSyncd/Java-8-Features-Step-By-Step/tree/master/src/e_CompletableFuture)

##
# 7 - Collection Improvements 

 ## (a) Map Interface added methods

    - LikedList replaced by BalancedTree
      When the number of Nodes in a particular hash Bucket grows beyond the threshold(TREEIFY_THRESHOLD = 8). 
      Content of that bucket switches from using a linked list of entry Objects to the BALANCED TREE.
      Balanced Tree improves the worst case performance o(n) to o(logn)

    - Added Methods
      >putIfAbsent() 
      >getOrDefault()
      >compute(), computeIfAbsent() and computeIfPresent()
      >replace(), replaceAll(), and remove()
    
     More Info : https://dzone.com/articles/how-to-use-java-hashmap-effectively
         
	  
 ## (b) Comparator Interface added methods
  
    - comparing() 
    - thenComparing()
    - naturalOrder()
    - reverseOrder()
    - nullsFirst
    - nullsLast
	  
##	  
# 8 - [Optional : java.util package](https://github.com/abhiSyncd/Java-8-Features-Step-By-Step/blob/master/src/1_Optional.md)

# 
    Other Sources : 
    https://www.javachinna.com/java-8-stream-functions-with-examples/
    https://www.javabrahman.com/java-8/java-8-grouping-with-collectors-groupingby-method-tutorial-with-examples/
