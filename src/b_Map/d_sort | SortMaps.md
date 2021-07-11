    Map <String,Integer> unsortedMap = new HashMap<>();
    
    unsortedMap.put("employee2", 2);
    unsortedMap.put("employee4", 4);
    unsortedMap.put("employee3", 3);
    unsortedMap.put("employee1", 1);
    
    
# 1 - Sort By Key 

**(a) Using TreeMap**

    --------------------
    Ex) Ascending Order
    --------------------
        Map<String,Integer> sortedMap = new TreeMap<>(unsortedMap);  		
        sortedMap.entrySet().forEach(System.out::println);

    --------------------
    Ex) Descending Order
    --------------------
        Map<String,Integer> sortedMap = new TreeMap<>((key1, key2) -> {
            return key2.compareTo(key1);
        });
        
        sortedMap.putAll(unsortedMap);
        
        sortedMap.entrySet().forEach(System.out::println);

**(b) Using Custom Comparator**



# 2 - Sort By Value




# Reference Links

  Source : https://pragmaticnotes.com/2017/08/10/benchmarking-approaches-to-sort-java-map-by-value/
