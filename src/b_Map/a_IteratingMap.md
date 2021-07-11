	Map <String, Integer> map = new HashMap <String,Integer>();
	map.put("employee1ID", 1);
	map.put("employee2ID", 2);
	map.put("employee3ID", 3);
	map.put("employee4ID", 4);

# 1 : Before Java 8 : External Iterators 
  
## (a) for-each-loop : using maps' keySet

    for (String key: map.keySet()) {
        System.out.println(key + ":" + map.get(key));
    }

    Output:
    employee2ID: 2
    employee1ID: 1
    employee4ID: 4
    employee3ID: 3

    Note: Insertion Order is not Maintained: Use LinkedHashMap instead
    
## (b) for-each-loop : using maps' EntrySet

    for (Map.Entry < String, Integer > entry: map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    Output:
    employee2ID: 2
    employee1ID: 1
    employee4ID: 4
    employee3ID: 3

    Note: Insertion Order is not Maintained: Use LinkedHashMap instead
		
## 2 :  Before Java 8 : Internal Iterators  
	
## (a) Using Iterator

    Iterator < Map.Entry < String, Integer >> itr = map.entrySet().iterator();
    while (itr.hasNext()) {
        Map.Entry < String, Integer > entry = itr.next();
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    Output:
    employee2ID: 2
    employee1ID: 1
    employee4ID: 4
    employee3ID: 3

    Note: Insertion Order is not Maintained: Use LinkedHashMap instead
  
# 3 : Using Java 8 
			
			
	// i)Using Consumer @FunctionalInterface as Anonymous inner class : It accepts one argument and returns no result

	     map.forEach(new BiConsumer<String,Integer>() {
		 public void accept(String key,Integer value) {
			 System.out.println(key + ":" + value);
		 }
	      });	


	     Output : 
                  employee2ID:2
		  employee1ID:1
		  employee4ID:4
		  employee3ID:3   

	     Note : Insertion Order is not Maintained : Use LinkedHashMap instead
		
	
	
	// ii)Using Lambda expression to instantiate Consumer @FunctionalInterface and avoid using bulky anonymous class implementations

		map.forEach((key,value) -> System.out.println(key + ":" + value)); 

		Output : 
		  employee2ID:2
		  employee1ID:1
		  employee4ID:4
		  employee3ID:3   

		 Note : Insertion Order is not Maintained : Use LinkedHashMap instead


        // iii) Using If Else inside ForEach Method 
	        map.entrySet().stream()
	        .forEach(
	                pair -> {
	                    if (pair.getValue() != null) {
	                    	
	                    } else {
	                       
	                    }
	                }
	        ); 
                
		//You can remove stream() above



 Note : using Stream API's stream() : No stream function for Map<String,String>


		      
			
			
			
			
			
