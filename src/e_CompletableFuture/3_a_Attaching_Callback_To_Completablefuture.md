## 1 - Need to Attach a Callback to a completableFuture

      Suppose we have a CompletableFuture and we need to process the result after it gets completed.
      We can do this after CompletableFuture.get(). But get() method is blocking.
      This means we need to wait until we get the result of the first task. 
      After getting the result, we can modify the result.

      But, that’s not what we want right? For building asynchronous systems 
      we should be able to attach a callback to the CompletableFuture which should 
      AUTOMATICALLY gets called when the completableFuture completes.

      In this way we won’t need to wait for the result.
      We can write the logic inside our callback function that needs to be executed 
      after the completion of the completableFuture



## 2 - Ways to Attach a Callback to a completableFuture :


 **2 - I) Processing|Transforming Result of a Completable Future**
 
       1)thenRun(Runnable Interface , Executor-optional)   | thenRunAsync(Runnable Interface , Executor-optional)      
	      : Runnable Interface has a method run() 
	      : that accepts NO-ARGUMENT and returns NO-OBJECT 
	      
       2)thenAccept(Consumer Interface , Executor-optional) | thenAcceptAsync(Consumer Interface , Executor-optional)   
	      : Consumer has a method 'accept()' 
	      : that accepts ONE-ARGUMENT and returns NO-OBJECT 
	      

       3)thenApply(Function Interface , Executor-optional) | thenApplyAsync(Function Interface , Executor-optional) 
	      : Function has a method 'apply()'  
	      : that accepts ONE-ARGUMENT and returns AN-OBJECT. 
		
		
	       Note : Async variants is available for all 3 Callbacks 
	              If 'Async' is applied, Then callback-method will run in seperate thread than completableFuture
     
     
     
     
   **2 - II) Chaining 2 Completable Future**
     
       The 2 methods used to combine results of 2 CompletableFutures

       1)thenCompose() : Used to Chain 2 INDEPENDENT CompletableFutures
	
       2)thenCombine(CompletableFuture, BiFunction-Functional-Interface) :  Used to Chain 2 DEPENDENT CompletableFutures
      
      
      
      
         
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
		
		
		
	
## 5 - [Next Section](https://github.com/abhiLinkd/Java-8-Features-Step-By-Step/blob/master/src/e_CompletableFuture/3_b_Attaching_Callback_To_Completablefuture.md)



