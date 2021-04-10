    Input  : List<List<String>>  : [[Sachin, Dhoni, Virat], [Warner, Watson, Smith]]
    Output : List<String>        : [Sachin, Dhoni, Virat, Warner, Watson, Smith]

 ## 1 : Before Java 8 

    List<String> teamIndia     = Arrays.asList("Sachin", "Dhoni", "Virat");
    List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
    
    List<List<String>> allPlayersList = Arrays.asList(teamIndia,teamAustralia ); // [[Sachin, Dhoni, Virat], [Warner, Watson, Smith]]  OR 
    
    //Above line can also be written as below commented line
    //List<List<String>> allPlayersList = new ArrayList<>();
    //allPlayersList.add(teamIndia);
    //allPlayersList.add(teamAustralia);
    
    List<String> listOfAllPlayers = new ArrayList<>();
    
    for (List<String> team : allPlayersList) {
       for (String name : team) {
          listOfAllPlayers.add(name);
       }
     }
			
    System.out.println("All Players - > " + listOfAllPlayers);  
			
    Output : All Players - > [Sachin, Dhoni, Virat, Warner, Watson, Smith]

	
		
 ## 2 : After Java 8
 
    List<String> teamIndia = Arrays.asList("Sachin", "Dhoni", "Virat");
    List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
    
    List<List<String>> allPlayersList = Arrays.asList(teamIndia, teamAustralia);
    
    List<String> flatMapList = allPlayersList.stream()
                               .flatMap(pList -> pList.stream())
			       .collect(Collectors.toList());
    
    System.out.println("All Players - > " + flatMapList);
