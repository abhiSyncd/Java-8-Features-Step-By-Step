## 1 - Manual Completion

   **Overview**
   
	     Future cannot be completed Manually, as It doesn't have any methods to do do But 
	     You can manually complete a CompletableFuture, by using complete(T value)
     
     
   **Description**
   
	   - future provides an 
	       >isDone() method   : to check whether the computation is done or not, and a 
	       >get()    method   : to retrieve the result of the computation when it is done. 
	       >cancel() method   : to cancel the computation

		But if there comes a scenario where you need to COMPLETE it manually, Future does not provides any methods to do so.
		Refer : Section III - Using Lambda : For Future Example
		        https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/1-c-CreatingThreads-Callable-with-Future


	   - CompletableFuture
	     CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
		    //Perform Long Running Task
	       })

	      String result = completableFuture.get(); 

	      Here,
	      Since we know that get() method blocks until the future is complete, 
	      the above call will block forever since the future is never completed. 
	      Therefore, we can use complete() method in order to manually complete the result.
	
	
   **Ex - Manually Completing the thread using CompletableFuture**
		  
	      CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			     //Perform Long Running Task
	       })

	      //Wait for 5 seconds 
	      Thread.sleep(5000L);  

	      //If completableFuture is Not Done in 5 seconds, 
	      //Complete it Manually and send response 'Unable To Process' else get the result 

	       if(!completableFuture.isDone()) {
		 System.out.println("Unable To Process");
		 completableFuture.complete("Unable To Process");
		}
		else{
		 completableFuture.get();
		}
	
	
## 2 - Attaching  a callable : Chaining 
   
   
   **Prerequisite**
   
	     What is a Callback Method
	     Callback-Methods are automatically get triggered and executed when an event ocuurs.
	     Here Event : Completion of a Async call

	     Advantage of Callback Method
	     we won’t need to wait for the Completion of a Method call
	     we can write the logic that needs to be executed after the Completion of a Method call inside our callback function.


  **Overview**
  
	    Future               : Future chaining is not possible. 
	                           We do not get notified when future is complete
				   neither does it provides us a callable method which will automatically be called when its completed.
				   i.e  If you want to execute one Future and then trigger another future once the first one is complete, this is not possible.

	    CompletableFuture   : provides us with a lot of callable methods which can be used as per our use case

				     1)thenApply(Function Interface , Executor-optional)  
						: Function has a method 'apply()'  
						: that accepts one argument and returns AN object. 

				     2)thenRun(Runnable Interface , Executor-optional)      
					      : Runnable Interface has a method run() 
					      : that accepts no argument and returns NO object.

				     3)thenAccept(Consumer Interface , Executor-optional)   
					       : Consumer has a method 'accept()' 
					       : that accepts one argument and returns NO result 


				      Note : async variants is available for all 3 Callbacks  



	Fore more Info Refer : 
	https://github.com/abhiLinkd/Java-8-Features-Step-By-Step/blob/master/src/e_CompletableFuture/c_Attaching_Callback_To_CompletableFuture
	https://www.callicoder.com/java-8-completablefuture-tutorial/



## 3 - Combining Multiple CompletableFuture
   
       We cannot combine multiple Future together. 
       If we want to run five different futures in parallel and then combine their result then this is not possible.
     
       But 
       
       We cannot combine multiple CompletableFuture together using CompletableFuture.allOf() method
       Example : Refer : 
       https://github.com/abhiLinkd/Java-8-Features-Step-By-Step/blob/master/src/e_CompletableFuture/d_Combining_Multiple_CompletableFuture



## 4 - Handling Exception

     Future does not have any exception handling mechanism.
     
     



