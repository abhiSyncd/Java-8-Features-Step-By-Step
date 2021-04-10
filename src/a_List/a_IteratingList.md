
    List<Integer> list = Arrays.asList(1, 2);

  
 # 1 : External Iterators 
 
## (a) for-loop
    
        for (int i = 0; i < list.size(); i++) {
             System.out.println(list.get(i));
        }


## (b) for-each-loop : TO-DO : Difference :
    
        for (int number : list) {
           System.out.println(number);
        }
		
				
 # 2 : Internal Iterators  
		
## (a) Using Iterator
        
	Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
           System.out.println(iter.next());
        }
		
		
## (b) Using ListIterator
      
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
           System.out.println(iter.next());
        }
	
	
 # 3 : Using Java 8 
			
## (a) Using Consumer @FunctionalInterface as Anonymous inner class : It accepts one argument and returns no result

       list.stream().forEach(new Consumer<Integer>() {
               public void accept(Integer number) {
                    System.out.println(number);
               }
         });	
		
		
## (b) Using Lambda expression to instantiate Consumer @FunctionalInterface and avoid using bulky anonymous class implementations
		
         list.stream().forEach((Integer number) -> System.out.println(number));   //OR
	 list.stream().forEach((number) -> System.out.println(number));           //OR
	 list.stream().forEach(number -> System.out.println(number));             //OR 
		
         list.stream().forEach(System.out::println);                              // Using Method-Reference : Passing a function inside a function
		
			
			
## (c) Using Stream API's stream() : Here stream() converts List<Integer> to  Stream<Integer>
     
         list.stream().forEach(System.out::println);

         //Using If-Else Inside For-Each
           list.stream()
           .forEach(number -> {
                      if(number % 2 == 0) {
                         System.out.println("Even number : "+ number);
                       }
                      else {
                         System.out.println("ODD Number :" + number);
                      }  
           });  	
			
					
			
