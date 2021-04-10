
   ## List<Integer> list = Arrays.asList(1, 2, 3);
	
 # 1 : Before Java 8
 
    List<Integer> transformedList = new ArrayList<>();
    
    for (Integer number : list) {
       transformedList.add(number * 2);
    }
    
    System.out.println(transformedList);  // [2, 4, 6]
   
   
   
# 2 : After Java 8 
   
    List<Integer> transformedList = list.stream()                                  
                                    .map(number-> number*2)       
                                    .collect(Collectors.toList());

    System.out.println(transformedList);

Here 

    -> list.stream()               : convert List<Integer> to  Stream<Integer>

    -> map(number-> number*2)      : can also be written as without using Lambda expression : 
                                     using @Function Interface  Function : 
                                     That Has a method 'apply()' : that accepts one argument and returns an object

                                     .map(new Function<Integer, Integer>() {
                                        public Integer apply(Integer number) {
                                            return number*2;
	                                }
                                     }) 

                                     Here <Integer, Integer>	    		
                                     > First Integer   : type of the input to the function
                                     > Second Integer  : type of the result of the function


     -> collect(Collectors.toList()) : convert Stream<Object> back to List<Integer> 
   
   
   
   
