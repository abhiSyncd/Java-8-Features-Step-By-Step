     Summary : 3 WAYS
     https://mincong.io/2020/05/30/exception-handling-in-completable-future/
     
     
     
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
 


# 2 - 

    CompletableFuture < String > future = CompletableFuture.supplyAsync(() - > {
        int number = 9 / 0;
        return "result from supplyAsync";
    })
    .handle((result, ex) - > {
        if (result != null) {
            System.out.println(result);                                                                  // On No-Exception in Pipeline : Return Final Response
            return result;
        } else {
            return "If Exception Caught |" + ex.getMessage() + "  | Return Error OR Some Mocked Value"; // On Exception in Pipeline    : Return Exception   
        }
    });


    System.out.println("Final Response -> " + future.get());
    
    
    OUTPUT :
    Final Response -> If Exception Caught |java.lang.ArithmeticException: / by zero  | Return Error OR Some Mocked Value
