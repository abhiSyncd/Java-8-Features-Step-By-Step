	Need: Parallel Execution

	Summary
	    (a) Running multiple futures in parallel and do something after all of them are complete.
		> allOf()
		> join(): prefferred

	    (b) Running multiple futures in parallel but The first completedFuture which completes will be returned         > anyOf()

	  
## Example - 1 - join()  
               	      
    CompletableFuture < Integer > future1 = CompletableFuture.supplyAsync(()-> {
	 Thread.sleep(3000L);
	 return 50;
    });
    CompletableFuture < Integer > future2 = CompletableFuture.supplyAsync(()-> 40);
    CompletableFuture < Integer > future3 = CompletableFuture.supplyAsync(()-> 30);


    List < Integer > list = Stream.of(future1, future2, future3)
		            .map(future-> future.join()) // .map(CompletableFuture::join)
		            .collect(Collectors.toList());
    
    System.out.println(list); // [50, 40, 30]
	

## Example 2 : anyOf() :  

    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()-> {
           Thread.sleep(10000L);
           return 50;
    });		
    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> 40);  
    CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()-> 30);


    CompletableFuture<Object> firstCompletedFuture = CompletableFuture.anyOf(future1, future2, future3);
    
    System.out.println("The first completed future value is " + firstCompletedFuture.get());   // 40
    
               
