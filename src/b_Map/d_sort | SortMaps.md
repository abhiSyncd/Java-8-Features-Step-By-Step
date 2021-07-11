    Map <String,Integer> unsortedMap = new HashMap<>();
    
    unsortedMap.put("employee2", 2);
    unsortedMap.put("employee4", 4);
    unsortedMap.put("employee3", 3);
    unsortedMap.put("employee1", 1);
    
    
# 1 - Sort By Key 

**(a) Using TreeMap**

    -----------------
    Ascending Order
    -----------------
    
        Map<String,Integer> sortedMap = new TreeMap<>(unsortedMap);  		
        sortedMap.entrySet().forEach(System.out::println);

    -----------------
    Descending Order
    -----------------
    
        Map<String,Integer> sortedMap = new TreeMap<>((key1, key2) -> {
            return key2.compareTo(key1);
        });
        
        sortedMap.putAll(unsortedMap);
        
        sortedMap.entrySet().forEach(System.out::println);

**(b) Using LinkedHashMap**

    -----------------
    Ascending Order
    -----------------
    
        Map sortedMap = unsortedMap.entrySet().stream()
	    .sorted(Map.Entry.comparingByKey())
	    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedMap.forEach((key, value) - > System.out.println(key + ":" + value));

    ----------------
    Descending Order
    ----------------


# 2 - Sort By Value




# Reference Links

  Source : https://pragmaticnotes.com/2017/08/10/benchmarking-approaches-to-sort-java-map-by-value/
