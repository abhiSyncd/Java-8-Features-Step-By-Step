
      
         
## 4 - Example 1 : Using thenApply(Function Interface , Executor-optional)

     
   **Example - 1** : Chaining Single thenApply()
     
		CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> {
			return Thread.currentThread().getName() + " - Long Running Task : Response from DB";
		});

		CompletableFuture<String> cFuture2 = cFuture1.thenApply(responseFromFuture1 -> {
		  return "Response After Tranformation in ThenApply Method : " + responseFromFuture1;
		});

		System.out.println(cFuture2.get());


	      Output : 
	      Response After Tranformation in ThenApply Method : ForkJoinPool.commonPool-worker-1 - Long Running Task : Response from DB


	       NOTE : 
		> Here Both cFuture1 and cFuture2 runs in SAME-THREAD, 
		  You can use thenApplyAsync() as a callback, instead of thenApply() to execute cFuture2 in SEPARATE-THREAD. 

		> Chaining Callbacks : You can chain multiple callbacks 
	
	

 **Example - 2** : Chaining Multiple thenApply()  
 
 
                CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> {
		    return Thread.currentThread().getName() + " - Long Running Task : Response from DB";
		}).thenApply(responseFromFuture1 -> {
		    return "Transformation 1";
		}).thenApply(responseFromFuture2 -> {
                    return "Transformation 2";
		});

		System.out.println(cFuture1.get());
		
		
	        Output : Transformation 2
		
		
		
	
## 5 - [Next Section](https://github.com/abhiSyncd/Java-8-Features-Step-By-Step/blob/master/src/e_CompletableFuture/3_b_Attaching_Callback_To_Completablefuture.md)



