                
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("employee1ID", 2);
		map.put("employee2ID", 1);
		map.put("employee3ID", 3);
		map.put("employee4ID", 4);

# 3 - Get Entry where Value is Maximum
				
    Map.Entry<String, Integer> entryObj = map.entrySet()
                                         .stream()
                                         .max(Map.Entry.comparingByValue())
                                         .get();

    System.out.println(entryObj.getKey() + " :: " + entryObj.getValue()); //employee4ID :: 4
    
    
# 4 -  Get 3 Entries with Max Value

    Map<String, Integer> entryWiThMaxValues = map.entrySet().stream() 
                                              .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                                              .limit(3)
                                              .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

    System.out.println(entryWiThMaxValues); //{employee1ID=10, employee4ID=4, employee3ID=3} : UseLinkedHashMap for InsertionOrder
