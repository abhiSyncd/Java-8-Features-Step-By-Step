
# 1 - Exception When CF is not Chained with Callback

	CompletableFuture <String> future = CompletableFuture.supplyAsync(()->{
	    int number = 9 / 0;
	    return "result from supplyAsync";
	}).exceptionally(ex->{
	    System.out.println("Oops! We have an exception - " + ex.getMessage());
	    return "Unknown!";
	});
	System.out.println("Final Response : " + future.get());


	OUTPUT:
	Oops!We have an exception - java.lang.ArithmeticException: / by zero
	Final Response : Unknown!
 
