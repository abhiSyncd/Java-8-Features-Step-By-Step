                
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("employee1ID", 2);
		map.put("employee2ID", 1);
		map.put("employee3ID", 3);
		map.put("employee4ID", 4);

# 1 - Sort By Key 
    https://javarevisited.blogspot.com/2017/07/how-to-sort-map-by-keys-in-java-8.html#axzz6rcP3BjwZ
    Map sorted = budget
	.entrySet()
	.stream()
	.sorted(comparingByKey())
	.collect(toMap(e -> e.getKey(),
	               e -> e.getValue(),
	              (e1, e2) -> e2), LinkedHashMap::new
                ));
      
      
      System.out.println("map after sorting by keys: " + sorted);

      The stream sorts all elements and then depending upon your need, 
      You can either print entries in sorted order or stored them in an ordered map e.g. LinkedHashMap or a sorted map e.g. TreeMap. 
      You can also sort entries in their reverse order by just reversing the Comparator using the Collections.reverseOrder() method or Comparator.reversed() method of Java 8.

# 2 - Sort By Value 



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
