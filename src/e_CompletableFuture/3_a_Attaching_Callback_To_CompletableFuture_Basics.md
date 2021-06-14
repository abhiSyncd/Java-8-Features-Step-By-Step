# 1 - Need to Attach a Callback to a completableFuture

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



# 2 - Ways to Attach a Callback to a completableFuture :


 ## 2 - I) Processing|Transforming Result of a Completable Future
 
       1)thenRun(Runnable Interface , Executor-optional)   | thenRunAsync(Runnable Interface , Executor-optional)      
	      : Runnable Interface has a method run() 
	      : that accepts NO-ARGUMENT and returns NO-OBJECT 
	      
       2)thenAccept(Consumer Interface , Executor-optional) | thenAcceptAsync(Consumer Interface , Executor-optional)   
	      : Consumer has a method 'accept()' 
	      : that accepts ONE-ARGUMENT and returns NO-OBJECT 
	      

       3)thenApply(Function Interface , Executor-optional) | thenApplyAsync(Function Interface , Executor-optional) 
	      : Function has a method 'apply()'  
	      : that accepts ONE-ARGUMENT and returns AN-OBJECT. 
		
		
	
     
## 2 - II) Chaining 2 Completable Future**
     
       The 2 methods used to combine results of 2 CompletableFutures

       1)thenCompose() : Used to Chain 2 INDEPENDENT CompletableFutures
	
       2)thenCombine(CompletableFuture, BiFunction-Functional-Interface) :  Used to Chain 2 DEPENDENT CompletableFutures
      
#  
   
 NOTE : 
 
    "Async variants" is available for all the above discussed Callbacks
    If 'Async' is applied, Then callback-method will run in seperate thread than completableFuture
     
     
     
     
     
