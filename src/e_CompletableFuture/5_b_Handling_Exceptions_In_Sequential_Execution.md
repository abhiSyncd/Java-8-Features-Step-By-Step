
# 1 -  Exception When CF is Chained with Callback 

## Case 1 : Exception caught in supplyAsync : Executing Callback
  
	 CompletableFuture <String> future = CompletableFuture.supplyAsync(()->{
	     System.out.println("supplyAsync executing");
	     int number = 9 / 0;
	     return "result from supplyAsync";
	 }).exceptionally(ex->{
	     System.out.println("Oops! We have an exception in supplyAsync - " + ex.getMessage());
	     return "Unknown!";
	 }).thenApply(result->{
	     System.out.println("thenApply Callback : executing");
	     System.out.println("thenApply Callback : result from supplyAsync -> " + result);

	     return " result from thenApply";
	 });

	 System.out.println("Final Response : " + future.get());


	 OUTPUT:
	 supplyAsync executing
	 Oops!We have an exception in supplyAsync - java.lang.ArithmeticException: / by zero
	 
	 thenApply Callback: executing
	 thenApply Callback : result from supplyAsync -> Unknown!
	  
	 Final Response :  result from thenApply


  ## Case 2 : Exception caught in supplyAsync : Not Executing Callback
  
  **Example 1 :** 
  
	CompletableFuture <String> future = CompletableFuture.supplyAsync(()-> {
	    System.out.println("supplyAsync executing");
	    int number = 9 / 0;
	    return "result from supplyAsync";
	}).thenApply(result->{
	    System.out.println(" thenApply Callback : executing");
	    System.out.println("thenApply Callback : result from supplyAsync -> " + result);
	    return " result from thenApply";
	}).exceptionally(ex-> {
	    System.out.println("Oops! We have an exception in supplyAsync - " + ex.getMessage());
	    return "Unknown!";
	});


	System.out.println("Final Response : " + future.get());

	OUTPUT : 
	supplyAsync executing
	
	Oops!We have an exception in supplyAsync - java.lang.ArithmeticException: / by zero
	
	Final Response : Unknown!

      
**Example 2 :** 

	CompletableFuture.supplyAsync(() - > {
	    System.out.println("supplyAsync executing");
	    int number = 9 / 0;
	    return "result from suuplyAsync";
	}).thenApply(result - > {
	    System.out.println("thenApply 1 executing");
	    return "result from thenApply 1";
	}).thenApply(result - > {
	    System.out.println("thenApply 2 executing");
	    return "result from thenApply 2";
	}).exceptionally(ex - > {
	    System.out.println("Oops! We have an exception - " + ex.getMessage());
	    return "IN VALID!";
	}).thenAccept(result - > {
	    System.out.println("DONE");
	});

        OUTPUT : 
	supplyAsync executing
	
	Oops!We have an exception - java.lang.ArithmeticException: / by zero
	
	DONE
	

# 
       Sources : 
	https://www.youtube.com/watch?v=9ueIL0SwEWI
	https://www.youtube.com/watch?v=-nDVy45eOYQ


