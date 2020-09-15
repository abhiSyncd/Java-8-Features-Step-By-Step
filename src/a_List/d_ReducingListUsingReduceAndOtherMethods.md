
	The Stream.reduce() method is a reduction operation. 
	A reduction operation takes a sequence of input elements and combines them into a single summary result.

	It is similar to SQL like Aggregate Functions : sum(),max(),min(),count,Mean,Median,Mode


## 1 - SUM of List Element


   **Before Java 8**

       List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
	int sum = 0;
	for (Integer number : list) {
	    sum = sum + number;  // sum1+=sum1
	}	
		  	  
	System.out.println(sum);  //10
		


   **After Java 8**
	
	List<Integer> list = Arrays.asList(1, 2, 3, 4);
	
	//Way 1 - Using Reduce()
	Integer sum =  list.stream()
	               .reduce(0 , (x,y) -> x+y);
		  
	System.out.println(sum);
		
	Note Here,
	i)First Parameter in reduce() : Identity Value
	  The identity element is both the initial value of the reduction and the default result if there are no elements in the stream.
	 -For Addition       : Identity value will be 0
	 -For Multiplication : Identity value will be 1
	
	
	//Using Stream's
	  Integer sum1 = list.stream().mapToInt(number -> number.intValue()).sum(); //OR
	  Integer sum2 = list.stream().mapToInt(Integer::intValue).sum();
	  
		
## 2 - Find Max and Min in List		
	
	
      //------------------------- Before Java 8 -------------------------
      
       List<Integer> list = Arrays.asList(1, 2, 3, 4);
       
	int max  = list.get(0);
	int min = list.get(0);
		    
	for (int i = 1; i < list.size(); i++) {
	   if (list.get(i) > max)
		 max = list.get(i);
	   else if (list.get(i)  < min)
		 min = list.get(i);
	}

	System.out.println(max);
        System.out.println(min);
      
   	
      //------------------------- After Java 8 -------------------------
      
      Optional<Integer> max = list.stream().reduce(Integer::max);
      Optional<Integer> min = list.stream().reduce(Integer::min);
      
      System.out.println(max);
      System.out.println(min);
	
	
	
 ### 3 - Total Count List Elements
 

   **Before Java 8**
     
       Integer totalCount = list.size();
       System.out.println(list.size());
       
       
     
   **After Java 8**
      
     Integer totalCount = list.stream().count();
     System.out.println(totalCount);

     Integer totalDistinctCount = list.stream().distinct().count(); 
     System.out.println(totalDistinctCount);
     
     
     
     
## 4 - Average(MEAN) of all List Elements 
     
       Mean = Sum of all values/Total No. of values
     
     
   **Before Java 8**
       
       Double total = 0.0;
		 
       for(int i=0; i<list.size(); i++){
	     total = total + list.get(i);
       }
		
       double average = total / list.size(); 	
		
       System.out.println(average);
      
         
   **After Java 8**  	
       
       //Way 1 : 
         double average1 = list
			   .stream()
			   .mapToInt(Integer::intValue)
			   .average()
			   .getAsDouble();
	System.out.println(average1); 
	
       //Way 2 : 
       Double average2 = list
			 .stream()
			 .collect(Collectors.averagingInt(number -> number));

        System.out.println(average2); 
	
	
	
	
	
## 5 - Median of all List Elements 
 
	Median is the middle number of a group of numbers.

	Step 1 : Sort Numbers in order from smallest to largest
		 Count all numbers in array = n;

	Step 2 : Two Possibilities based on count n : 
		Case I  - There's an odd number of elements in List :  Median  = Middle element =  ((n + 1)/2)th 
		Case II - There's an even number of elements in List : Median  = Sum of Two Middle Numbers / 2 =  [((n)/2)th item term + ((n)/2 + 1)th item term ]/2




