

     //https://www.mkyong.com/java8/java-8-filter-a-map-examples/



  
## 1 : Before Java 8
 
                
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("employee1ID", 1);
		map.put("employee2ID", 2);
		map.put("employee3ID", 3);
		map.put("employee4ID", 4);
		
		Map<String, Integer> transformedMap = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			transformedMap.put(entry.getKey(), entry.getValue()*2);
		}

		System.out.println(transformedMap);
		
		
		Output : {employee2ID=4, employee1ID=2, employee4ID=8, employee3ID=6}
		
        Note   : Insertion order is not maintained :  Use LinkedHashMap instead
          
  
  
## 2 : After Java 8
  
                Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("employee1ID", 1);
		map.put("employee2ID", 2);
		map.put("employee3ID", 3);
		map.put("employee4ID", 4);

		Map<String, Integer> transformedMap = map.entrySet().stream()
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue() * 2));

		System.out.println(transformedMap);
		
		
		
		Output : {employee2ID=4, employee1ID=2, employee4ID=8, employee3ID=6}
		
        Note   : Insertion order is not maintained : Use LinkedHashMap instead
          
          
          
          
   
