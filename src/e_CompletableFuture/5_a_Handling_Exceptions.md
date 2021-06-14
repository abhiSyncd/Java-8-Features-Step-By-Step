
	https://www.youtube.com/watch?v=9ueIL0SwEWI
	https://www.youtube.com/watch?v=-nDVy45eOYQ


# 1 - Without Chaining 


    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			int number = 9/0;
			return "Some result";
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		});	
    System.out.println(future.get());
	

    Oops! We have an exception - java.lang.ArithmeticException: / by zero
    Unknown!

  
  
# 2 - With Chaining 

  **Case 1 : Exception caught in supplyAsync : Entering Callback**
    
     CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
          System.out.println("supplyAsync executing");
          int number = 9/0;
          return "result from supplyAsync";
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception in supplyAsync - " + ex.getMessage());
            return "result from caught Exception";
        }).thenApply(result -> {
            System.out.println(" thenApply Callback : executing");
          System.out.println(" Result received From SupplyAsync in thenApply Callback: " + result);

          return " result from thenApply";
        });


        System.out.println(future.get());
        
 #       
        Output : 
        supplyAsync executing
        Oops! We have an exception in supplyAsync - java.lang.ArithmeticException: / by zero
          thenApply Callback : executing
          Result received From SupplyAsync in thenApply Callback : result from caught Exception
          result from thenApply


  **Case 2 : Exception caught in supplyAsync : Not Entering Callback**

     CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync executing");
            int number = 9/0;
            return "result from supplyAsync";
          }).thenApply(result -> {
              System.out.println(" thenApply Callback : executing");
            return " result from thenApply";
          }).exceptionally(ex -> {
              System.out.println("Oops! We have an exception in supplyAsync - " + ex.getMessage());
              return "result from caught Exception";
          });


          System.out.println(future.get());



    supplyAsync executing
    Oops! We have an exception in supplyAsync - java.lang.ArithmeticException: / by zero
    result from caught Exception


      
