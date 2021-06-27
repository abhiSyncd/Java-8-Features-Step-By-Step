     Summary : 3 WAYS
     https://mincong.io/2020/05/30/exception-handling-in-completable-future/
     
     
     
# 1 - Using exceptionally

	CompletableFuture <String> future = CompletableFuture.supplyAsync(()->{
	    int number = 9 / 0;
	    return "result from supplyAsync";
	}).exceptionally(ex->{
	    return "Exception Caught |" + ex.getMessage() + "  | Return Error OR Some Mocked Value"; 
	});
	System.out.println("Final Response : " + future.get());


    OUTPUT :
    Final Response -> Exception Caught |java.lang.ArithmeticException: / by zero  | Return Error OR Some Mocked Value
 


# 2 - Using handle

    CompletableFuture < String > future = CompletableFuture.supplyAsync(() - > {
        int number = 9 / 0;
        return "result from supplyAsync";
    })
    .handle((result, ex) - > {
        if (result != null) {
            return result;
        } else {
            return "Exception Caught |" + ex.getMessage() + "  | Return Error OR Some Mocked Value"; 
        }
    });


    System.out.println("Final Response -> " + future.get());
    
   
    OUTPUT :
    Final Response -> Exception Caught |java.lang.ArithmeticException: / by zero  | Return Error OR Some Mocked Value
