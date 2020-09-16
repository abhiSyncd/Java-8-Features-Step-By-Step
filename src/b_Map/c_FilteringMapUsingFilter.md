

##  1 : Applying Single Filter : Find Even Values in Map

 
	 // i)Before Java 8

                        Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("employee1ID", 1);
			map.put("employee2ID", 2);
			map.put("employee3ID", 3);
			map.put("employee4ID", 4);	


			Map<String, Integer> filteredMap = new HashMap<String, Integer>();

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if(entry.getValue() % 2 == 0){
				filteredMap.put(entry.getKey(), entry.getValue());
				}
			}

			System.out.println(filteredMap);

  
  
  
        // ii)After Java 8

                Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("employee1ID", 1);
		map.put("employee2ID", 2);
		map.put("employee3ID", 3);
		map.put("employee4ID", 4);	
		
		Map<String, Integer> filteredMap = map.entrySet().stream()
				 .filter(mapElements -> mapElements.getValue()%2==0)
				 .collect(Collectors.toMap(mapElements -> mapElements.getKey(), mapElements -> mapElements.getValue()));

		System.out.println(filteredMap); 
 
 
        Output : {employee2ID=2, employee4ID=4}
        
