


 ## 1 : Applying Single Filter : Find Even Number in List  

 
   **i) Before Java 8**

	    List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> transformedList = new ArrayList<>();

		for (Integer number : list) {
			  if(number % 2 == 0){
				transformedList.add(number);
			  }
		}

	    System.out.println(transformedList); // [2, 4]
 
 
 
  **ii) After Java 8**
  
  
	    List<Integer> list = Arrays.asList(1, 2, 3, 4);

	    List<Integer> transformedList = list.stream()
			    .filter(number -> number%2==0)
			    .collect(Collectors.toList());

			System.out.println(transformedList);    // [2, 4]



	 Here ,Using @Function Interface - Predicate Interface as Anonymous inner class instead of lambda
	       Predicate Interface : Has a method 'test()' : that accepts one argument and returns Boolean result

	 Here,Above line : filter(number -> number%2==0) : can be written as below


		      .filter(new Predicate<Integer>() {
					public boolean test(Integer number) {
						 if(number % 2 == 0)  return true;
						 else return false;
					}
				})

	            
 	
## 2 : Applying Multiple Filter : Find Even Number that is > 3 in List
 	
 	
 	
  **i) Before Java 8**
 	
 	List<Integer> list = Arrays.asList(1, 2, 3, 4);
	List<Integer> transformedList = new ArrayList<>();
		
	     for (Integer number : list) {
			  if(number>3 && number % 2 == 0 ){
				transformedList.add(number);
			   }
		   }
		
		System.out.println(transformedList);  //4
		
		
	
 **ii) After Java 8**
	
	List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
	List<Integer> transformedList = list.stream()
		            .filter(number -> number>3)
			        .filter(number -> number%2==0)
			        .collect(Collectors.toList());
		  
		  
		System.out.println(transformedList);
	
 	
 	
 	

## 3 : Combining Filters and Transformation


   **i) Before Java 8 :  Find Double of each 'Even Number greater than 3' in List**
   
   	List<Integer> list = Arrays.asList(1, 2, 3, 4);
	List<Integer> transformedList = new ArrayList<>();
		
		  for (Integer number : list) {
			  if(number>3 && number % 2 == 0 ){
				transformedList.add(number*2);
			   }
		   }
		  
		System.out.println(transformedList);
   


   **ii) After Java 8 : :  Find Double of each 'Even Number greater than 3' in List**
   
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
	List<Integer> transformedList = list.stream()
		            .filter(number -> number>3)
			        .filter(number -> number%2==0)
			        .map(number-> number*2)
			        .collect(Collectors.toList());	
		  
	System.out.println(transformedList);
		
		
		
		

 	
 	
