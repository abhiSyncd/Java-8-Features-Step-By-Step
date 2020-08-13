



## Example - 1 - allOf() + join()  

If we need to run multiple futures in parallel and combine their result
              	      
	      CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
	      CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
	      CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

	      List<Integer> list = Stream.of(future1, future2, future3)
	                .map(future -> future.join())  // .map(CompletableFuture::join)
	                .collect(Collectors.toList());
	      
	      
	      System.out.println(list);  // [50, 40, 30]

      


## Example 2 : anyOf() :  

If we need to run multiple futures in parallel but The first completedFuture which completes will be returned.

		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
			try {
			  Thread.sleep(20000);
			} catch (InterruptedException e) {
			  e.printStackTrace();
			}
			return 50;
		});
		
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

		CompletableFuture<Object> firstCompletedFuture = CompletableFuture.anyOf(future1, future2, future3);

		try {
                  System.out.println("The first completed future value is " + firstCompletedFuture.get());   // 40
		} catch (Exception e) {
                  e.printStackTrace();
		}

		System.out.println("Code that should be executed after any of the futures complete.");

               
