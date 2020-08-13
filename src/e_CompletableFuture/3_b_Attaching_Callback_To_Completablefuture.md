
 ## 5 - Example : thenCombine(CompletableFuture, BiFunction-Functional-Interface) : 
 
       - It accepts a Future and a BiFunction to process both results. 
       - Used to Chain 2 DEPENDENT CompletableFutures


       - Example
       
         CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 50;
         });

         CompletableFuture<Integer> resultFuture = future.thenCombine(
                                                CompletableFuture.supplyAsync(() -> 20),
                                                (num1, num2) -> num1 + num2);

         System.out.println(resultFuture.get()); 
      
      
         Output : 70 
