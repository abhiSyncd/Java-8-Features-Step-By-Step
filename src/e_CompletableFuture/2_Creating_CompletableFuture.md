
## 1 - What is CompletableFuture

	A CompletableFuture is a class in Java that belongs to the java.util.concurrent package.
     
	It is used for asynchronous computation.
	
	Synchronous Execution : 
	Synchronous execution refers to line-by-line execution of code. If a function is invoked, the program execution waits until the function call is completed. 
	Synchronous execution blocks at each method call before proceeding to the next line of code. 
	A program executes in the same sequence as the code in the source code file. Synchronous execution is synonymous to serial execution.
		
	Asynchronous (or async) execution 
	Asynchronous programming is a form of parallel programming that allows a unit of work to run separately 
	from the main application thread. 
	When the work is complete, it notifies the main thread (as well as whether the work was completed or failed). 
	There are numerous benefits to using it, such as improved application performance and enhanced responsiveness.
	
	Refer : https://www.youtube.com/watch?v=9ueIL0SwEWI : For Java 8 + CompletableFuture overview


## 2 - Ways to create CompletableFuture : Overview 


**I - Using runAsync(Runnable Interface , Executor-optional )**

	   Parameters : 
	    - Runnable-Interface has a method run() : that accepts no argument and returns NO object.
	    - Executor-Interface : Thread Pool (Optional)
	    
	   Use Case :
	    - Since it returns NO object, 
	      So It is used to we just want to execute the code and do nothing with the result.


**II - Using supplyAsync(Supplier Interface , Executor-optional )**

	   Parameters :
	     - Supplier-Interface Has a method 'get()' : that accepts no  argument and returns AN object.
	     - Executor-Interface : Thread Pool (Optional)
	     
	   Use Case : 
	     Since it returns AN object So, 
	     It is used if we want to do something with the result of the method


## 3 -  Example : Using supplyAsync 


 **Way 1 : Using Supplier-Functional-Interface as Anonymous Inner Class**
 
    
	       CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
		  @Override
		   public String get() {
			  return (Thread.currentThread().getName() + " - Long Running Task : Response from DB");
			 }
	       });

	       System.out.println(Thread.currentThread().getName() +  " - Main Thread Do not wait for completableFuture and executes");


	       /**
		 * 
		 * Manual Completion of CompletableFuture : 
		 * If Below statement is uncommented
		 * Then, Application Do not wait for completableFuture to complete.
		 * 
		 * completableFuture.complete("Cached Response : Future's Result on Manual completion");  
		 */	


	       System.out.println(completableFuture.get());

	   
	       Output : 
	       main : Main Thread Do not wait for completableFuture and executes
	       ForkJoinPool.commonPool-worker-1 : Long Running Task : Response from DB


 **Way 2 : Using Supplier-Functional-Interface in Lambda Expression**
 
 
           CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {
			//Takes a Thread from Default Fork-Join-Thread-Pool and executes task
			return Thread.currentThread().getName() + " - Long Running Task : Response from DB";
	   });

	   System.out.println(Thread.currentThread().getName() + " - Main-Thread Do not wait for completableFuture to complete and executes");

	   System.out.println(cFuture.get());
	    
	    
	    Output : 
	    main : Main Thread Do not wait for completableFuture and executes
	    ForkJoinPool.commonPool-worker-1 : Long Running Task : Response from DB
		
		
## 4 - Discussion

        You might be wondering that - Well, I know that the runAsync() and supplyAsync() methods execute their tasks in a separate thread. 
	But, we never created a thread right?

	CompletableFuture BY-DEFAULT executes these tasks in a thread obtained from the global ForkJoinPool.commonPool(),
	which uses daemon threads to execute the Runnable task

	But hey, you can also create a Thread Pool(using  Executor which is optional) and pass it to runAsync() and supplyAsync() methods 
	to let them execute their tasks in a thread obtained from your thread pool.

	All the methods in the CompletableFuture API has two variants - One which accepts an Executor as an argument and one which doesn’t.
