    Map <String,Integer> unsortedMap = new HashMap<>();
    
    unsortedMap.put("employee2", 2);
    unsortedMap.put("employee4", 4);
    unsortedMap.put("employee3", 3);
    unsortedMap.put("employee1", 1);
    
    
# 1 - Sort By KEY 

## (a) Using TreeMap

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

## (b) Using LinkedHashMap

     Steps
     > Iterate Map using Streams
     > Sort it : Either By Key Or Value
     > Collect and return a new LinkedHashMap (keep the order)

#
    -----------------
    Ascending Order
    -----------------
    
        Map sortedMap = unsortedMap.entrySet().stream()
         .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())) // .sorted(Map.Entry.comparingByKey())
         .collect(Collectors.toMap(
             Map.Entry::getKey,
             Map.Entry::getValue,
             (e1, e2) -> e1,
             LinkedHashMap::new));

        sortedMap.forEach((key, value) -> System.out.println(key + ":" + value));
	
    -----------------
    Descending Order
    -----------------
    
        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))              OR
        .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))



# 2 - Sort By VALUE

## (a) Using LinkedHashMap

    -----------------
    Ascending Order
    -----------------
    
        Map sortedMap = unsortedMap.entrySet().stream()
            .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())) // .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new));

        sortedMap.forEach((key, value) -> System.out.println(key + ":" + value));
    
    -----------------
    Descending Order
    -----------------
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))          OR
        .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))




# Reference Links

    Source :
    https://stackabuse.com/how-to-sort-a-hashmap-by-key-in-java
    https://pragmaticnotes.com/2017/08/10/benchmarking-approaches-to-sort-java-map-by-value/
    https://dzone.com/articles/how-to-sort-a-map-by-value-in-java-8
