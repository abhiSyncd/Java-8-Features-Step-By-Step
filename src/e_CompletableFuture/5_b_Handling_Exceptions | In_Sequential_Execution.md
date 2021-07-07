    
# SUMMARY : 
	 
	Two ways to Handle Exception while Sequential Execution Pipeline in Completable Future

	(a) Using exceptionally
	    - At end of the the Pipeline
	    - At Middle of the Pipeline
	(b) Using handle
	    - At end of the the Pipeline 
	    - At Middle of the Pipeline

	Note : In Both Cases : 
	       If Exception caught in Any Block ({}) > Pipeline Breaks  
	       > The exceptionally Block Executes and returns               > The Next Block in The pipeline continue executing
	       > The handle() method's ELSE statement Executes  and returns > The Next Block in The pipeline continue executing
	 
	 
# 1 -  Using exceptionally

  ## Case 1 : At end of the the Pipeline
  
	CompletableFuture <String> future = CompletableFuture.supplyAsync(() -> {
	    System.out.println("supplyAsync executing");
	    int number = 9 / 0;
	    return "result from supplyAsync";
	})
	.thenApply(result -> {
	    System.out.println(" thenApply Callback : executing");
	    System.out.println("thenApply Callback : result from supplyAsync -> " + result);
	    return " result from thenApply";
	})
	.exceptionally(ex -> {
	    System.out.println("Oops! We have an exception in supplyAsync - " + ex.getMessage());
	    return "IN VALID!";
	});


	System.out.println("Final Response : " + future.get());  // Note : We are not using ThenAccept() at the end 

	OUTPUT : 
	supplyAsync executing
	Oops!We have an exception in supplyAsync - java.lang.ArithmeticException: / by zero
	Final Response :IN VALID!
	
## Case 2 : At Middle of the Pipeline

     CompletableFuture.supplyAsync(() -> {
         System.out.println("supplyAsync executing");
         int number = 9 / 0;
         return "result from suuplyAsync";
     })
     .thenApply(result -> {
         System.out.println("thenApply 1 executing");
         return "result from thenApply 1";
     })
     .thenApply(result -> {
         System.out.println("thenApply 2 executing");
         return "result from thenApply 2";
     })
     .exceptionally(ex -> {
         System.out.println("Oops! We have an exception - " + ex.getMessage());
         return "IN VALID!";
     })
     .thenAccept(result -> {
         System.out.println("Final Response : " +  result);         // Note : We are using ThenAccept() at the end : So future.get not-required
     });
     
     
     OUTPUT : 
     supplyAsync executing
     Oops!We have an exception - java.lang.ArithmeticException: / by zero
     Final Response : IN VALID!
	
      

# 2 - Using handle 

  ## Case 1 : At end of the the Pipeline
  
    CompletableFuture < String > future = CompletableFuture.supplyAsync(() -> {
        System.out.println("supplyAsync executing");
        int number = 9 / 0;
        return "result from suuplyAsync";
    })
    .thenApply(result -> {
        System.out.println("thenApply 1 start");
        System.out.println("Do something with the result got from : supplyAsync");
        System.out.println("thenApply 1 stop");
        return "result from thenApply 1";
    })
    .thenApply(result -> {
        System.out.println("thenApply 2 : start");
        System.out.println("Do something with the result got from : thenApply 1");
        System.out.println("thenApply 2 : start");
        return "result from thenApply 2";
    })
    .handle((result, ex) -> {
        if (result != null) {
            System.out.println(result);                      // On No-Exception in Pipeline : Return Final Response
            return result;
        } else {
            return "Exception Caught: " + ex.getMessage();   // On Exception in Pipeline    : Return Exception   
        }
    });
    
    
    System.out.println("Final Response : " + future.get());  
    
    
    OUTPUT : 
    supplyAsync executing
    Exception Caught
    Final Response : Error handling: java.lang.ArithmeticException: / by zero

	  

## Case 2 : At Middle of the Pipeline

    CompletableFuture.supplyAsync(() -> {
        System.out.println("supplyAsync executing");
        int number = 9 / 0;
        return "result from suuplyAsync";
    })
    .thenApply(result -> {
        System.out.println("thenApply 1 start");
        System.out.println("thenApply 1 : result from supplyAsync : " + result);
        System.out.println("thenApply 1 stop");
        return "result from thenApply 1";
    })
    .handle((result, ex) -> {
        if (result != null) {
            System.out.println(result);
            return result;
        } else {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "IN VALID!";
        }
    }).thenAccept(result -> {
        System.out.println("Final Response : " + result); // Note : We are using ThenAccept() at the end : So future.get not-required
    });
    
    
    OUTPUT : 
    supplyAsync executing
    Oops! We have an exception - java.lang.ArithmeticException: / by zero
    Final Response : IN VALID!


# 
       Sources : 
	https://www.youtube.com/watch?v=9ueIL0SwEWI
	https://www.youtube.com/watch?v=-nDVy45eOYQ


